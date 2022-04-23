package WaitNotify;

public class SynchronizeOnObjects {


    public static void main(String[] args) {
        Object lock = new Object();

        Runner runner = new Runner();
        Thread t1 = new Thread(runner);
        Thread t2 = new Thread(runner);

        t1.start();
        t2.start();
    }

}


class Runner implements Runnable {

    public synchronized void f() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " I: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public synchronized void g() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " J: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
       f();
       g();

    }
}