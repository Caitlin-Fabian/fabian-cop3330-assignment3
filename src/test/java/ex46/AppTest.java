package ex46;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void wordCounter() {
    App app = new App();
    String[] array = {"badger", "badger","badger", "badger", "mushroom", "mushroom", "snake"};
    assertEquals(4, app.wordCounter(array,"badger"));
    assertEquals(2, app.wordCounter(array, "mushroom"));
    assertEquals(1, app.wordCounter(array,"snake"));
    }
}