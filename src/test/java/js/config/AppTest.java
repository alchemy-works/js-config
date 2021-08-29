package js.config;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void textConfig() throws IOException {
        var name = new App().config().get("name");
        assertEquals("JavaScript Configuration", name);
    }
}
