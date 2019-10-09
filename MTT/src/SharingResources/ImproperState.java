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


    private int val = 0;
    @Override
    public void run() {

        //WHere are missing ticks?
        for (int i = 0; i < 1000; i++) {
            aInt.getAndIncrement();
                    Thread.yield();
            aInt.getAndIncrement();
        }
        showDataState();
    }

    public void showDataState() {
        System.out.print(Thread.currentThread() + " ; ");
        System.out.println(aInt.get());
    }
}