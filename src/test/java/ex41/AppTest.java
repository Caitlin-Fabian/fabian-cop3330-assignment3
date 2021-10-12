package ex41;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void sorting() {
        App app = new App();
        List<String> list = new ArrayList<>();
        list.add("Ling, Mai");
        list.add("Johnson, Jim");
        list.add("Zarnecki, Sabrina");
        list.add("Jones, Chris");
        list.add("Jones, Aaron");
        list.add("Swift, Geoffrey");
        list.add("Xiong, Fong");

        List<String > copy = new ArrayList<>();
        copy.addAll(list);
        Collections.sort(copy);

        assertEquals(copy,app.sorting(list));
    }
}
