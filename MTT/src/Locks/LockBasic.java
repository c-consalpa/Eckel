package Locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasic {
    public static void main(String[] args) {
        LockWorker lockWorker = new LockWorker();

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(lockWorker);
            thread.start();
        }
    }
}

class LockWorker implements Runnable {
    Lock lock = new ReentrantLock();
    boolean isFree = false;

    @Override
    public void run() {
        try {
            lock.lock();
            for (int i = 0; i < 100; i++) {
                Thread.sleep(100);
                System.out.print(Thread.currentThread());
                System.out.print(" :op1;");
                System.out.println("op2;");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}