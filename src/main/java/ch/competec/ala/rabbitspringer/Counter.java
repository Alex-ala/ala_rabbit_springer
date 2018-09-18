package ch.competec.ala.rabbitspringer;

import java.util.concurrent.Semaphore;

public class Counter {
    //Counting with semaphores, why not. Thread safety ftw
    static Semaphore write = new Semaphore(0);
    public static Semaphore getWrite() {
        return write;
    }

    static Semaphore read = new Semaphore(0);
    public static Semaphore getRead(){return read;}
}
