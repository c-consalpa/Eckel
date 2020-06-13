package SharingResources;

import java.util.concurrent.atomic.AtomicInteger;

public class ImproperState {
    public static void main(String[] args) {
        ImproperStateWorker worker = new ImproperStateWorker();
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(worker);
            thread.start();
        }
    }
}

class ImproperStateWorker implements Runnable {
    AtomicInteger aInt = new AtomicInteger();

    @Override
    public void run() {
        //Where are the missing ticks?
        for (int i = 0; i < 100000; i++) {
            aInt.getAndIncrement();
            Thread.yield();
        }
        System.out.println(Thread.currentThread() + " : work done: " + aInt.get());
    }
}