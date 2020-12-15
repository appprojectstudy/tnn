package com.pj.tnn.thread;


public class ThreadPool {
    public static final int DEFAULT_MAX_THREAD_COUNT = 16;
    public static final int DEFAULT_MIN_THREAD_COUNT = 0;
    public static final int DEFAULT_INITIAL_THREAD_COUNT = 4;
    public static final int DEFAULT_ALLOWED_IDLE_COUNT = 5;

    public WorkQueue workQueue = new WorkQueue();

    private int maxThreadCount;
    private int minThreadCount;

    private int createdThreadCount = 0;
    private int workThreadCount = 0;
    private int idleThreadCount = 0;
    private int allowedIdleCount = 0;
    public static boolean closed = false;

    private static int groupId = 0;
    private static int threadId = 0;
    public ThreadPool(int initThreadCount, int maxThreadCount,
                      int minThreadCount, int allowedIdleCount) {

        if (minThreadCount < 0) minThreadCount = 0;
        if (initThreadCount < minThreadCount)
            initThreadCount = minThreadCount;
        if (maxThreadCount < minThreadCount
                || maxThreadCount < initThreadCount)
            maxThreadCount = Integer.MAX_VALUE;

        if (allowedIdleCount < 0) allowedIdleCount = DEFAULT_INITIAL_THREAD_COUNT;

        this.minThreadCount = minThreadCount;
        this.maxThreadCount = maxThreadCount;
        this.createdThreadCount = initThreadCount;
        this.idleThreadCount = initThreadCount;
        this.allowedIdleCount = allowedIdleCount;

        for (int i = 0 ; i < this.createdThreadCount ; i++ ) {
            new PooledThread().start();
        }
    }

    public ThreadPool(int initThreadCount, int maxThreadCount, int minThreadCount) {
        this(initThreadCount, maxThreadCount, minThreadCount, DEFAULT_ALLOWED_IDLE_COUNT);
    }

    public synchronized void execute(Runnable work) throws AleadyClosedException {
        if (closed) throw new AleadyClosedException();

        increasePooledThread();
        workQueue.enqueue(work);
    }

    public synchronized void close() throws AleadyClosedException {
        if (closed) throw new AleadyClosedException();
        closed = true;
        workQueue.close();
    }

    private void increasePooledThread() {
        synchronized(workQueue) {
            if (idleThreadCount == 0 && createdThreadCount < maxThreadCount) {
                new PooledThread().start();
                createdThreadCount ++;
                idleThreadCount ++;
            }
        }
    }

    private void beginRun() {
        synchronized(workQueue) {
            workThreadCount ++;
            idleThreadCount --;
        }
    }

    public boolean terminate() {
        synchronized(workQueue) {
            workThreadCount --;
            idleThreadCount ++;

            if (idleThreadCount > allowedIdleCount && createdThreadCount > minThreadCount) {
                createdThreadCount --;
                idleThreadCount --;

                return true;
            }
            return false;
        }
    }

    private class PooledThread extends Thread {

        public PooledThread() {
        }

        public void run() {
            try {
                while( !closed ) {
                    Runnable work = workQueue.dequeue();

                    beginRun();
                    work.run();
                    if (terminate() ) {
                        break;
                    }
                }
            } catch(InterruptedException | AleadyClosedException ex) {
            }
        }
    }

    public void printStatus() {
        synchronized(workQueue) {
            Log.d("TEST", "Total Thread="+createdThreadCount);
            Log.d("TEST", "Idle  Thread="+idleThreadCount);
            Log.d("TEST", "Work  Thread="+workThreadCount);
        }
    }
}
