package js.config;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;

import java.io.IOException;
import java.util.Map;

public class App {

    public Map<?, ?> config() throws IOException {
        var script = "import config from './config.js';config";
        return Context.newBuilder("js")
                .allowIO(true)
                .build()
                .eval(Source.newBuilder("js", script, "_.mjs").build())
                .as(Map.class);
    }
}
