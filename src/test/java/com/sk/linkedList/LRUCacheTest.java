package com.sk.linkedList;

import com.sk.linkedLists.LRUCacheImpl;
import org.junit.Test;

/**
 * Created by suppalamethi on 10/23/2015.
 */
public class LRUCacheTest {

    @Test
    public void testLRUCache() {
        LRUCacheImpl<Integer, String> lruCache = new LRUCacheImpl(4);

        lruCache.add(10, "Ten");
        System.out.println(lruCache.toString());

        lruCache.add(20, "Twenty");
        lruCache.add(30, "Thirty");
        lruCache.add(40, "Forty");
        lruCache.add(50, "Fifty");
        System.out.println(lruCache.toString());

        lruCache.get(60);
        lruCache.get(10);
        lruCache.get(40);

        lruCache.add(10, "Ten");
        lruCache.add(70, "Seventy");
        lruCache.add(80, "Eighty");

        System.out.println(lruCache.toString());
    }
}
