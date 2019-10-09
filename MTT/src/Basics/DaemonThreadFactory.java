package Basics;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

class myThreadClass extends Thread {

    public myThreadClass(Runnable target) {
        super(target);
        System.out.println("Thread created :" + this.currentThread().getName());
    }

    @Override
    public void run() {
        super.run();
    }
}

public class DaemonThreadFactory implements ThreadFactory {


    @Override
    public Thread newThread(Runnable r) {
        Thread t = new myThreadClass(r);
        t.setDaemon(true);
        return t;
    }
}

class DaemonThreadFactoryTest {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());

        exec.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("test in : " + Thread.currentThread().getName());
            }
        });


    }
}
