package SharingResources;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class StringGen implements Runnable{
    private int i;
    public StringGen(int i) {
        this.i = i;
    }

    private synchronized void showOutput() {
        System.out.print(Thread.currentThread() + " : ");
        for (int j = 0; j < 10; j++) {
            System.out.print(j);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    @Override
    public void run() {
        showOutput();
    }
}

public class StringGenTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        StringGen str =  new StringGen(5);

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(str);
            thread.start();
        }
    }

}
