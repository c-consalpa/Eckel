package MTT;

import static MTT.TrueFalseTicker.lock;
import static MTT.TrueFalseTicker.swtch;

public class TrueFalseTicker {
    public static boolean swtch = false;
    public static final Object lock = new Object();
    public static void main(String[] args) {
        Ticker ticker = new Ticker();


        Thread thread1 = new Thread(ticker);
        Thread thread2 = new Thread(ticker);

        thread1.start();
        thread2.start();
    }
}


class Ticker implements Runnable {

    @Override
    public void run () {
        for (int i = 0; i < 100; i++) {
            synchronized (TrueFalseTicker.lock) {
                if (swtch) {
                    System.out.println(Thread.currentThread() + " : " + swtch);
                    swtch = !swtch;
                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    System.out.println(Thread.currentThread() + " : " + swtch);
                    swtch = !swtch;
                    lock.notifyAll();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }
        }
    }
}