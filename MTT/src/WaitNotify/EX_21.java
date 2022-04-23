package WaitNotify;



import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX_21 {
    public static void main(String[] args) throws InterruptedException {
        WorkerA a = new WorkerA();
        WokerB b = new WokerB(a);
        ExecutorService executorService = Executors.newCachedThreadPool();

            executorService.execute(a);
            executorService.execute(b);

        Thread.sleep(3000);
        executorService.shutdownNow();
    }
}

class WorkerA implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("ex a");
                e.printStackTrace();
            }
            System.out.println("message");
//        display a message:

        }
    }
}

class WokerB implements Runnable {
    WorkerA refA;

    public WokerB(WorkerA refA) {
        this.refA = refA;
    }

    @Override
    public void run() {
        synchronized (refA) {
        try {
            System.out.println("Work b");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("ex b");
            e.printStackTrace();
        }
         refA.notifyAll();
}
    }
}

