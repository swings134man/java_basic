package com.lucas.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @package : com.lucas.cache
 * @name : ThreadSafeWithExpCache.java
 * @date : 2025. 1. 8. 오후 3:04
 * @author : lucaskang(swings134man)
 * @Description: Multi Thread 환경에서 Safe 하고 Expire 기능을 가진 Cache 구현체
**/
public class ThreadSafeWithExpCache<K, V> {

    /* ---------------- Constants -------------- */

    /**
     * Default Expire Time: 1 hour
     */
    private static final long DEFAULT_EXPIRE_TIME = 60 * 60 * 1000;

    /* ---------------- Objects  -------------- */

    private static class CacheItem<V> {
        final V value;
        final Long expireTime; // if null then never expire Cache

        /**
         * All Value Constructor
         * @param value Cache Value {@code V}
         * @param expireTime Expire Time in {@code Milliseconds}
         */
        CacheItem(V value, Long expireTime) {
            this.value = value;
            this.expireTime = expireTime;
        }

        /**
         * Constructor without Expire Time
         * @param value Cache Value {@code V}
         */
        CacheItem(V value) {
            this(value, null);
        }
    }

    private final ConcurrentHashMap<K, CacheItem<V>> cache = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler;

    /* ---------------- Constructors  -------------- */

    /**
     * Default Class Constructor - Create Scheduler with 1 Thread
     */
    public ThreadSafeWithExpCache() {
        this.scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(this::cleanup, 30* 1000, 30 & 1000, TimeUnit.MILLISECONDS); // 30s cycle cleanup
    }

    /* ---------------- Public operations -------------- */

    /**
     * Put Cache Item with Default Expire Time
     *
     * Default Expire Time is 1 hour
     *
     * @param key Cache Key {@code K}
     * @param value Cache Value {@code V}
     * @throws NullPointerException if {@code key}, {@code value} is null
     * @author : lucaskang(swings134man)
     */
    public void put(K key, V value) {
        if(key == null || value == null)
            throw new NullPointerException();

        long expireTime = System.currentTimeMillis() + DEFAULT_EXPIRE_TIME;
        cache.put(key, new CacheItem<>(value, expireTime));
    }

    /**
     * Put Cache Item with Expire
     * @param key Cache Key {@code K}
     * @param value Cache Value {@code V}
     * @param expireTime Expire Time in {@code Milliseconds}
     * @throws NullPointerException if {@code key}, {@code value}  is null, or @{code expireTime < 0}
     * @author : lucaskang(swings134man)
     */
    public void put(K key, V value, long expireTime) {
        if(key == null || value == null || expireTime < 0)
            throw new NullPointerException();

        long expireTimeMillis = System.currentTimeMillis() + expireTime;
        cache.put(key, new CacheItem<>(value, expireTimeMillis));
    }

    /**
     * Put Cache Item without Expire
     * @param key Cache Key {@code K}
     * @param value Cache Value {@code V}
     * @throws NullPointerException if {@code key}, {@code value} is null
     * @author : lucaskang(swings134man)
     */
    public void putWithoutExpire(K key, V value) {
        if(key == null || value == null)
            throw new NullPointerException();

        cache.put(key, new CacheItem<>(value));
    }

    /**
     * Get Cache Item by Key
     * @param key Cache Key
     * @return if Cache Item is Exist and not Expired return {@code value}
     * @throws NullPointerException if key is null
     * @author : lucaskang(swings134man)
     */
    public V get(K key) {
        if(key == null)
            throw new NullPointerException();

        CacheItem<V> cacheItem = cache.get(key);
        if(cacheItem == null)
            return null;

        if(cacheItem.expireTime != null && cacheItem.expireTime < System.currentTimeMillis()) {
            cache.remove(key);
            return null;
        }
        return cacheItem.value;
    }

    /**
     * Check if the Cache contains the Key
     * @param key Cache Key
     * @return {@code true} : if this com.lucas.cache contains the key And not Expired
     * @author : lucaskang(swings134man)
     */
    public boolean containsKey(K key) {
        CacheItem<V> cacheItem = cache.get(key);

        if(cacheItem == null)
            return false;

        return cacheItem.expireTime == null || cacheItem.expireTime >= System.currentTimeMillis();
    }

    /**
     * Remove Cache Item by Key
     * @param key  Cache Key
     * @author : lucaskang(swings134man)
     */
    public void remove(K key) {
        cache.remove(key);
    }

    /**
     * Clear All Cache Items
     * @author : lucaskang(swings134man)
     */
    public void clear() {
        cache.clear();
    }

    /**
     * return Cache Size
     * @return {@code int} : Cache Size
     * @author : lucaskang(swings134man)
     */
    public int size() {
        return cache.size();
    }

    /**
     * Shutdown the Scheduler
     * @author : lucaskang(swings134man)
     */
    public void shutdown() {
        scheduler.shutdown();
        System.out.println("Cache Scheduler Shutdown!");
    }

    /* ---------------- Private operations -------------- */

    /**
     * Clean up Expired Cache Items
     * @author : lucaskang(swings134man)
     */
    private void cleanup() {
        long now = System.currentTimeMillis();
        cache.forEach((key, cacheItem) -> {
            if(cacheItem.expireTime != null && cacheItem.expireTime < now) {
                cache.remove(key);
            }
        });
    }
}//end of class
