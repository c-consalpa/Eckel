package WaitNotify.Sample;

public class ThreadLastsForever implements Runnable {
    @Override
    public void run() {

    }


    public ThreadLastsForever() {
        Thread thread = new Thread(this);
        thread.start();

    }
}


class Main1 {
    public static void main(String[] args) {
        ThreadLastsForever threadLastsForever = new ThreadLastsForever();
    }
}