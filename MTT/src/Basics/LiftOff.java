package Basics;

public class LiftOff implements Runnable {
    protected int countDown = 10; // Default
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }
    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
    }
    public void run() {
        while(countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}

//class MainThread {
//    public static void main(String[] args) {
//        LiftOff launch = new LiftOff();
//        launch.run();
//    }
//}

class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        Thread t1 = new Thread(new LiftOff());
        t.start();
        t1.start();
        System.out.println("Waiting for LiftOff");
    }
}