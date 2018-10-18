package com.bootdo.common.utils;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KeyGenerator {

    private static ConcurrentLinkedQueue<String> keyCache = new ConcurrentLinkedQueue<String>();

    public static String genImageName(){
    	//取当前时间的长整形值包含毫秒
    	long millis = System.currentTimeMillis();
    	Random random = new Random();
    	//加上3位随机数
    	int end3 = random.nextInt(999);
    	//如果不足3位前面补0
    	String str = millis + String.format("%03d", end3);
    	return str;
    }
    
    public static String nextKey() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            if (keyCache.isEmpty()) {
                generateKeys();
            }
            return keyCache.poll();
        } catch (Exception e) {
        } finally {
            lock.unlock();
        }
        return null;
    }

    private static void generateKeys() {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            for (int i = 0; i < 100; i++) {
                String key = UUID.randomUUID().toString().replace("-", "").toUpperCase();
                if (!keyCache.contains(key)) {
                    keyCache.add(key);
                }
            }
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(nextKey());
        }
    }

}

