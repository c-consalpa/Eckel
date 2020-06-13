package SharingResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class StringGen implements Runnable{
    private int i;
    public StringGen(int i) {
        this.i = i;
    }

    private void showOutput() {

        synchronized (Sync.Sync) {
            System.out.println(Thread.currentThread() + " : ");
            for (int j = 0; j < 10; j++) {
                System.out.println(i + " : " + j);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Override
    public void run() {
        showOutput();
    }
}

// Mock class with a static field to sync on. bad practice;
class Sync {
    public static Object Sync = new Object();
}
public class StringGenTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        StringGen str = new StringGen(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new StringGen(i));
        }

    }
}
