package WaitNotify.Sample;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DS {
    public int i, j = 0;

    public synchronized void incI() {
        this.i++;
    }

    public synchronized void incJ() {
        this.j++;
    }

    public synchronized int getI() {
        return i;
    }

    public synchronized int getJ() {
        return j;
    }

    public void dumpState() {
        System.out.println(Thread.currentThread().getName() + " : " + "I: " + i + "; " + "J: " + j);
    }

    public synchronized boolean workDone() {
        if (getJ() == 5 && getI() == 5) {
            return true;
        }
        return false;
    }
}

class HandlerI implements Runnable {
    private DS ds;
    public HandlerI(DS ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        synchronized (ds) {
            try {
                while(ds.getI() < 5) {
                    ds.incI();
                    System.out.println(Thread.currentThread().getName() + " : " + ds.getI());
                    ds.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(500);
//                    if (ds.getI() >= 5) break;
                    ds.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("Catched an Interrupt: " + Thread.currentThread().getName());
            }
        }
    }
}

class HandlerJ implements Runnable {
    private DS ds;
    public HandlerJ(DS ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        synchronized (ds) {
            try {
                while(ds.getJ() < 5) {

                   ds.incJ();
                   System.out.println(Thread.currentThread().getName() + " : " + ds.getJ());

                    ds.notifyAll();
                    TimeUnit.MILLISECONDS.sleep(500);
//                    if (ds.getJ() >= 5) break;
                    ds.wait();

                }
            } catch (InterruptedException e) {
                System.out.println("Catched an Interrupt: " + Thread.currentThread().getName());
            }
        }
        System.out.println("End task HandlerJ");
    }
}

class StopWatcher implements Runnable {
    private DS ds;
    private List<Thread> theads;

    public StopWatcher(DS ds, List<Thread> workersList) {
        this.ds = ds;
        this.theads = workersList;
    }

    @Override
    public void run() {
        synchronized (ds) {
            try {
                while (!ds.workDone()) {
                    ds.dumpState();
                    ds.wait();

                }
                System.out.println("Finished: ");
                ds.dumpState();

                for (Thread t:
                        theads) {
                    System.out.println("send interrupt to " + t.getName());
                    t.interrupt();
                }

           } catch (InterruptedException ex) {

            }
        }
    }
}

class Main {
    public static void main(String[] args) {
        DS struct = new DS();
        Thread t1 = new Thread(new HandlerI(struct), "I");
        Thread t2 = new Thread(new HandlerJ(struct), "J");
        Thread t3 = new Thread(new StopWatcher(struct, Arrays.asList(t1,t2)), "STOPWatcher_Thread");

        t1.start();
        t2.start();
        t3.start();

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }
}


