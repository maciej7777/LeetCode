package solutions.p0146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {
    /**
     * Input
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
     * Output
     * [null,null,null,1,null,-1,null,-1,3,4]
     * Expected
     * [null,null,null,1,null,-1,null,-1,3,4]
     */
    @Test
    public void testLRUCacheWithLeetcodeScenario() {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        assertEquals(1, lRUCache.get(1));

        lRUCache.put(3, 3);
        assertEquals(-1, lRUCache.get(2));

        lRUCache.put(4, 4);
        assertEquals(-1, lRUCache.get(1));
        assertEquals(3, lRUCache.get(3));
        assertEquals(4, lRUCache.get(4));
    }
}