package MTT;

import java.util.Random;

import static MTT.WaitTicker.counter;

public class WaitTicker {
    static int counter = 2;
    public static void main(String[] args) {

        CounterTask task1 = new CounterTask();


        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task1);

        t1.start();
        t2.start();
    }
}

class CounterTask implements Runnable {
    Object lock = new Object();
    @Override
    public void run() {
        Random random = new Random();
        synchronized (lock) {
            for (int i = 0; i < 10; i++) {
//                try {
//                    Thread.sleep((long) random.nextInt(1000));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
                if (counter % 2 == 0) {
                    System.out.println(Thread.currentThread() + " : " + "even " + counter);
                    counter++;
                    try {
                        lock.notify();
                        lock.wait();

                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                } else {
                    System.out.println(Thread.currentThread() + " : " + "odd " + counter);
                    counter++;

                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            lock.notifyAll();
        }
    }
}


