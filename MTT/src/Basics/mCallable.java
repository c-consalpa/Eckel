package Basics;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class mCallable {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(3);
        Future<String> future = exec.submit(new TaskWithResult());
        future.toString();
    }
}

class TaskWithResult implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "abc";
    }
}