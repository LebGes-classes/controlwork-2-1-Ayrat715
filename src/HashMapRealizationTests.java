import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

public class HashMapRealizationTests {
    HashMapRealization<Integer, String> map;
    @BeforeEach
    public void setup() {
        map = new HashMapRealization<>();
        map.put(1, "One");
        map.put(2, "Two");
    }
    
    @org.junit.jupiter.api.Test
    public void testPutAndGet() {
        assertEquals("One", map.get(1));
        assertEquals("Two", map.get(2));
    }

    @org.junit.jupiter.api.Test
    public void testContainsKey() {
        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(3));
    }

    @org.junit.jupiter.api.Test
    public void testContainsValue() {
        assertTrue(map.containsValue("One"));
        assertFalse(map.containsValue("3"));
    }

    @org.junit.jupiter.api.Test
    public void testRemove() {
        assertTrue(map.containsKey(1));
        map.remove(1);
        assertFalse(map.containsKey(1));
    }

    @org.junit.jupiter.api.Test
    public void testSize() {
        assertEquals(2, map.size());
        map.remove(1);
        assertEquals(1, map.size());
    }
}
