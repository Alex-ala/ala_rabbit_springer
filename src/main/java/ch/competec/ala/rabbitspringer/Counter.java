package ch.competec.ala.rabbitspringer;

import java.util.concurrent.Semaphore;

public class Counter {
    static Semaphore s = new Semaphore(0);
    public static Semaphore getS() {
        return s;
    }
}
