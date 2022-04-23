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
    public volatile Flag flag;

    public FlagSetter(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {

                while (true) {
                    synchronized (flag) {
                        flag.flg = true;
                    }

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

            while (true) {

                if (flag.flg == true) {
                    synchronized (flag) {
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