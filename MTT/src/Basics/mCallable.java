package Basics;

import java.util.concurrent.*;

public class mCallable {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future<String> future = exec.submit(new TaskWithResult());
        try {
//            System.out.println(future.get());
            future.get(1000, TimeUnit.MICROSECONDS);

        } catch (InterruptedException | ExecutionException e) {

            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("why wait. cancel task");
            future.cancel(true);
            e.printStackTrace();
        }
        exec.shutdown();
    }
}

class TaskWithResult implements Callable<String> {

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "abc";
    }
}