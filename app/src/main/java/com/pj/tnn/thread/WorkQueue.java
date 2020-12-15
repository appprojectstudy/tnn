package com.pj.tnn.thread;

import java.util.LinkedList;

public class WorkQueue {
    private LinkedList workList = new LinkedList();
    private boolean closed = false;

    public synchronized void enqueue(Runnable work)
            throws com.pj.tnn.thread.AleadyClosedException {
        if (closed) {
            throw new com.pj.tnn.thread.AleadyClosedException();
        }
        workList.addLast(work);
        notify();
    }

    public synchronized Runnable dequeue()
            throws com.pj.tnn.thread.AleadyClosedException, InterruptedException {
        while( workList.size() <= 0 ) {
            wait();
            if ( closed ) {
                throw new com.pj.tnn.thread.AleadyClosedException();
            }
        }
        return (Runnable)workList.removeFirst();
    }

    public synchronized int size() {
        return workList.size();
    }

    public synchronized void close() {
        closed = true;
        notifyAll();
    }
}

