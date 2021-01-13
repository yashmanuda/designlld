package cache;

import cache.evictionpolicy.LRUEvictionPolicy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LRUCacheTest {
    private Cache<String, String> lruCache;

    @Before
    public void setUp() throws Exception {
        lruCache = new Cache<>(new LRUEvictionPolicy<String>(), 5);
    }

    @Test
    public void testCache() {
        lruCache.put("key1", "value1");
        lruCache.put("key2", "value2");
        lruCache.put("key3", "value3");
        lruCache.put("key4", "value4");
        lruCache.put("key5", "value5");
        lruCache.put("key6", "value6");
        Assert.assertNull(lruCache.get("key1"));
        String val2 = lruCache.get("key2");
        Assert.assertEquals("value2", val2);
        lruCache.put("key7", "value7");
        Assert.assertNull(lruCache.get("key3"));
        lruCache.put("key7", "value7_2");
        Assert.assertEquals("value7_2", lruCache.get("key7"));
    }
}