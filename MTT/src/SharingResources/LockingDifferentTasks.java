package SharingResources;

//import org.omg.PortableServer.THREAD_POLICY_ID;

public class LockingDifferentTasks {
    public static void main(String[] args) {
        Locker locker = new Locker();
        WorkerA a = new WorkerA(locker);
        WorkerB b = new WorkerB(locker);


            Thread threada = new Thread(a);
            Thread threadb = new Thread(b);
            threada.start();
            threadb.start();

    }
}

class WorkerA implements Runnable{
Locker locker;

    public WorkerA(Locker locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        synchronized (this.locker) {


            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread());
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}

class WorkerB implements Runnable{
    Locker locker;

    public WorkerB(Locker locker) {
        this.locker = locker;
    }
    @Override
    public void run() {
        synchronized (this.locker) {
            for (int i = 50; i < 60; i++) {
                System.out.println("X");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }
}

class Locker {
    public String word = "abc";
}