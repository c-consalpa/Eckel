package ConcurrentUtilities;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledExec {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor scheduledExec = new ScheduledThreadPoolExecutor(4);
        scheduledExec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }, 2, 5, TimeUnit.SECONDS);

    }
}
