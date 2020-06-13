package Basics;

import java.util.concurrent.*;

public class mCallable {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future<String> future = exec.submit(new TaskWithResult());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        exec.shutdown();
    }
}

class TaskWithResult implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "abc";
    }
}