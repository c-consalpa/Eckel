package Interrupts;

import Basics.LiftOff;
import Basics.mTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CustomInterrupt {
    public static void main(String[] args) {
        mTask task = new mTask();
        Thread th = new Thread(task);
        th.start();
        System.out.println(th.isInterrupted());
        th.interrupt();
        System.out.println(th.isInterrupted());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(th.isInterrupted());
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(task);
//        exec.shutdownNow();




    }
}
