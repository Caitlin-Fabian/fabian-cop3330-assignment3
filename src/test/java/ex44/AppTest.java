package ex44;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void presentProduct() throws Exception {

        App app = new App();
        assertEquals(true, app.presentProduct("Widget"));
        assertEquals(false, app.presentProduct("ipad"));
    }
}