package com.lucas.cache;

/**
 * @package : com.lucas.cache
 * @name : CacheTestcom.lucas.java
 * @date : 2025. 1. 8. 오후 2:55
 * @author : lucaskang(swings134man)
 * @Description: Java In-Memory Cache Sample
 *
 * - Spring 또는 Library 의 도움을 받지않고 POJO 로 Cache 를 구현하는 방법.
 * - 간단한 방법으로는 HashMap 을 사용하는 방법이 존재함.
 * - Multi Thread 환경에서는 동기화 문제가 발생할 수 있으므로, ConcurrentHashMap 을 사용하는 것이 좋다.
 * - EXP 를 구현하기 위해서는 만료로직에 대한 부분을 추가해야한다.
**/
public class CacheTestMain {
    public static void main(String[] args) throws InterruptedException{
        ThreadSafeWithExpCache<String, String> cache = new ThreadSafeWithExpCache<>();

        // 기본 expireTime Cache put
        cache.put("key1", "value1");
        System.out.println("default Expire Cache : " + cache.get("key1")); // value1

        // expireTime 1초 Cache put
        cache.put("key2", "value2", 1000);
        System.out.println("expire 1s Cache : " + cache.get("key2")); // value2

        // expireTime 이 없는 Cache put
        cache.putWithoutExpire("key3", "value3");

        // expireTime 5초 Cache put
        cache.put("key4", "value4", 5 * 1000);

        // 5초 대기 --------------------------
        Thread.sleep(5000);
        // ---------------------------------
        System.out.println("------------------------ Expire ------------------------");
        System.out.println("expire 1s Cache : " + cache.get("key2")); // null
        // expireTime 이 없는 Cache get
        System.out.println("No Expire Cache : " + cache.get("key3")); // value3
        System.out.println("expire 5s Cache : " + cache.get("key4")); // null

        // size
        System.out.println("size : " + cache.size()); // 2

        System.out.println("------------------------ Utils ------------------------");
        // remove
        cache.remove("key1");
        System.out.println("default Expire Cache : " + cache.get("key1")); // null

        // contains
        System.out.println("contains key3 not clear : " + cache.containsKey("key3")); // true

        // clear
        cache.clear();
        System.out.println("contains key4 : " + cache.containsKey("key4")); // false

        System.out.println("------------------------ ShutDown ------------------------");

        // Graceful Shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run() {
                System.out.println("Shutdown Hook is calling !");
                cache.shutdown();
            }
        });
    }
}
