package WaitNotify;

import static WaitNotify.customProdCons.*;

public class customProdCons {
    static int buffer = 0;
    public static boolean produced = false;
    public static Object lock = new Object();

    public static void main(String[] args) {
        Producer producer = new Producer();
        Consumer consumer = new Consumer(producer);

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
         for (int i = 0; i < 10; i++) {
             buffer = i;
             System.out.println(buffer);
             Thread.sleep(150);
         }
         System.out.println("Data generated. Waiting for cnsumer");
         synchronized (this) {
             produced = true;
             notifyAll();
             wait();
         }
    }
}

class Consumer implements Runnable {
    Producer producer;
    public Consumer(Producer producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        synchronized (producer) {
            while (!produced) {
                try {
                    producer.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            while (true) {
                System.out.println("data detected: " + buffer) ;

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("ping producer for more data");
                synchronized (producer) {
                    System.out.println(buffer);
                    produced = !produced;

                    try {
                        producer.notifyAll();
                        producer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}