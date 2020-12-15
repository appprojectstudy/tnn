package com.pj.tnn.thread;

public class AleadyClosedException extends Exception {

    public AleadyClosedException(String msg) {
        super(msg);
    }

    public AleadyClosedException() {
        super();
    }
}