package com.yjl.javabase.concurrent;

import com.yjl.javabase.threadaction.BarrierTimer;

import java.net.Inet4Address;
import java.util.Properties;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by yangjunlin on 2015/12/19.
 */
public class SynchronizationComparisons {
    static BaseLine baseLine = new BaseLine();
    static SynchronizedTest synchronizedTest = new SynchronizedTest();
    static LockTest lockTest = new LockTest();
    static AtomicTest atomicTest = new AtomicTest();

    static void test() {
        System.out.println("=====================================");
        baseLine.timeTest();
        synchronizedTest.timeTest();
        lockTest.timeTest();
        atomicTest.timeTest();
        Accumulator.report(synchronizedTest, baseLine);
        Accumulator.report(lockTest, baseLine);
        Accumulator.report(atomicTest, baseLine);
        Accumulator.report(synchronizedTest, lockTest);
        Accumulator.report(synchronizedTest, atomicTest);
        Accumulator.report(lockTest, atomicTest);
    }

    public static void main(String[] args) {
        int iterations = 5;
        baseLine.timeTest();
        for (int i = 0; i < iterations; i++) {
            test();
            Accumulator.cycies *= 2;
        }
        Accumulator.executorService.shutdown();
        System.out.println("*********************");
    }
}

class AtomicTest extends Accumulator {
    {
        id = "AtomicTest";
    }

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);

    @Override
    public void accumulate() {
        int i = index.getAndIncrement();
        value.getAndAdd(preload[i]);
        if (i >= size) {
            index.set(0);
        }
    }

    @Override
    public long read() {
        return value.get();
    }
}

class LockTest extends Accumulator {
    {
        id = "LockTest";
    }

    private Lock lock = new ReentrantLock();

    @Override
    public void accumulate() {
        lock.lock();
        try {
            value += preload[index++];
            if (++index >= size) {
                index = 0;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public long read() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class SynchronizedTest extends Accumulator {
    {
        id = "SynchronizedTest";
    }

    @Override
    public synchronized void accumulate() {
        value += preload[index++];
        if (++index >= size) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class BaseLine extends Accumulator {
    {
        id = "Baseling";
    }

    @Override
    public void accumulate() {
        if (index >= size) {
            index = 0;
        }
        value += preload[index++];
    }

    @Override
    public long read() {
        return value;
    }
}

abstract class Accumulator {
    public static int cycies = 5000;
    protected volatile long value = 0;
    protected volatile int index = 0;
    protected static final int size = 100000;
    protected static int[] preload = new int[size];
    private static final int N = 4;
    public static ExecutorService executorService = Executors.newFixedThreadPool(2 * N);
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(2 * N + 1);
    protected long duration = 0;
    protected String id = "test";

    static {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            preload[i] = random.nextInt();
        }
    }

    public abstract void accumulate();

    public abstract long read();

    private class Modifier implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < cycies; i++) {
                accumulate();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    private class Reader implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < cycies; i++) {
                read();
            }
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }

    public void timeTest() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            executorService.execute(new Modifier());
            executorService.execute(new Reader());
        }
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        duration = System.nanoTime() - start;
        System.out.println("id: " + id + ", duration: " + duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2) {
        System.out.println(acc1.id + "/" + acc2.id + ": " + (double) acc1.duration / (double) acc2.duration);
    }
}
