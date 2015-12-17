package com.yjl.javabase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;

/**
 * Created by on 12/17/15.
 */
public class ReentrantLock {
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(10);
    public int num = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //                        add();
                }
            }).start();
        }
       /* for (int i = 0; i < 10; i++)
            EXECUTOR.execute(new Runnable() {
                public void run() {
                    try {
                        add();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });*/
        System.out.println("end");
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
    class Count {
         int num = 0;
        Lock lock;

         void test() {

        }
    }
}

