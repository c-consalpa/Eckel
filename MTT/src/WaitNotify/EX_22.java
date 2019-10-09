package WaitNotify;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EX_22 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Flag flag = new Flag();
        FlagSetter flagSetter = new FlagSetter(flag);
        FlagObserver flagObserver = new FlagObserver(flag);

        exec.execute(flagSetter);
        exec.execute(flagObserver);
    }
}


class FlagSetter implements Runnable {
    Flag flag;

    public FlagSetter(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        
            try {
                while (true) {
                    Thread.sleep(100);
                    flag.flg = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}

class FlagObserver implements Runnable{
Flag flag;

    public FlagObserver(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        synchronized (flag) {
            while (true) {
                System.out.println(flag.flg);
                if (flag.flg == true) {
                    System.out.println("true detected, reverting..");
                    flag.flg = false;
                }
            }
        }
    }
}

class Flag {
    public boolean flg = false;
}