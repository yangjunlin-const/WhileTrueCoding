package com.yjl.javabase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Created by on 12/17/15.
 */
public class ReentrantLock {
    private static final ExecutorService EXECUTOR = Executors.newCachedThreadPool();
    public volatile static int num = 0;
    private Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.test();
    }

    void test() {
        for (int i = 0; i < 20; i++) {
            EXECUTOR.execute(new Add());
        }
        EXECUTOR.shutdown();
    }

    /*synchronized void add() {
        num++;
        System.out.println(num);
    }
*/
    void add() {
        lock.lock();
        try {
            num++;
            System.out.println(num);
        } finally {
            lock.unlock();
        }
    }

    class Add implements Runnable {
        public Add() {

        }

        @Override
        public void run() {
            add();
        }

      /*  synchronized void add() {
            num++;
            System.out.println(num);
        }*/
    }

   /* private static void add() throws InterruptedException {
        Lock lock = new java.util.concurrent.locks.ReentrantLock();
        lock.lockInterruptibly();
        System.out.println(num++);
        lock.unlock();
    }*/

   /* private static int add() throws InterruptedException {
        Lock lock = new java.util.concurrent.locks.ReentrantLock();
//        lock.lockInterruptibly();
        lock.lock();
//        lock.tryLock();
        num++;
        System.out.println(num);
        lock.unlock();
        return num;
    }*/

    /* private static synchronized void add() throws InterruptedException {
         num++;
         System.out.println(num);
     }*/
}

