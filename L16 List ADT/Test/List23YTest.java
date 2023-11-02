import list23ystudent.ArrayList23Y;
import list23ystudent.DoubleLinkedList23Y;
import list23ystudent.List23Y;
import list23ystudent.SingleLinkedList23Y;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class List23YTest {
    private List23Y list;
    @BeforeEach
    void setUp() {
        //list = new ArrayList23Y();
        //list = new SingleLinkedList23Y();
        list = new DoubleLinkedList23Y();
    }

    @Test
    void add() {
        list.add("A");
        assertEquals(0, list.indexOf("A"));
        list.add("B");
        assertEquals(1, list.indexOf("B"));
    }

    @Test
    void remove() {
        list.add("A");
        list.add("B");
        assertEquals(2, list.size());
        list.remove("A");
        assertEquals(1, list.size());
        assertFalse(list.contains("A"));
        list.remove("B");
        assertEquals(0, list.size());
        assertFalse(list.contains("B"));
    }

    @Test
    void contains() {
        list.add("A");
        assertTrue(list.contains("A"));
        list.add("B");
        assertTrue(list.contains("B"));
    }

    @Test
    void clear() {
        list.add("A");
        list.add("B");
        list.clear();
        assertFalse(list.contains("A"));
        assertFalse(list.contains("B"));
        assertEquals(0, list.size());
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add("A");
        assertEquals(1, list.size());
        list.add("A");
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add("A");
        list.remove("A");
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        list.add("A");
        assertEquals("A", list.get(0));
        list.add("B");
        assertEquals("B", list.get(1));
    }

    @Test
    void testAdd() {
        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");
        assertEquals("C", list.get(0));
        assertEquals("B", list.get(1));
        list.add(1, "D");
        assertEquals("D", list.get(1));
    }

    @Test
    void testRemove() {
        list.add(0, "A");
        list.add(0, "B");
        list.add(0, "C");

        list.remove(1);
        assertEquals("C", list.get(0));
        assertEquals("A", list.get(1));
    }
}
