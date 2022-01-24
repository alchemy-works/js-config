package js.config;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

public class App {

    public Map<?, ?> config() throws IOException {
        var s = """
                export default {
                    name: 'JavaScript Configuration'
                }
                """;

        var script = "(await import('data:text/javascript;base64,%s'))['default']".formatted(Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8)));
        var context = Context.newBuilder("js").build();
        try (context) {
            var source = Source.newBuilder("js", script, "_.mjs").build();
            return context.eval(source).as(Map.class);
        }
    }
}
