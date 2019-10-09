package MTT;

import sun.awt.windows.ThemeReader;

import static MTT.customProdCons.*;

public class customProdCons {
    static int buffer = 0;
    public static boolean produced = false;
    public static Object lock = new Object();
    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}


class Producer implements Runnable {

    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce() throws InterruptedException {
     while (true) {
         for (int i = 0; i < 10; i++) {
             buffer = i;
             System.out.print(buffer);
             Thread.sleep(150);
         }
         System.out.println("Data generated. Waiting for cnsumer");
         synchronized (lock) {
             produced = true;
             lock.notifyAll();
             lock.wait();
         }
     }

    }
}

class Consumer implements Runnable {

    @Override
    public void run() {
        synchronized (lock) {
            while (!produced) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.print("data detected: ");
                synchronized (lock) {
                    System.out.println(buffer);
                    produced = !produced;

                    try {
                        lock.notifyAll();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}