package BlockingQueues;

import java.util.concurrent.*;

import java.io.*;
import java.util.*;

class mSender implements Runnable {
    private Random rand = new Random(47);
    public BlockingDeque<Character> q = new LinkedBlockingDeque<>();
    public void run() {
        try {
            while(true)
                for(char c = 'A'; c <= 'z'; c++) {
                    q.add(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch(InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}
class mReceiver implements Runnable {
    BlockingDeque<Character> queue;
    public mReceiver(mSender msender) throws IOException {
        queue = msender.q;
    }
    public void run() {
        while(true) {
// Blocks until characters are there:
            if (queue.peek() != null) {
                System.out.println("Read: " + queue.poll() + ", ");
            }

        }
    }
}
public class PipedWuthBlockingQueue {
    public static void main(String[] args) throws Exception {
        mSender msender = new mSender();
        mReceiver mreceiver = new mReceiver(msender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(msender);
        exec.execute(mreceiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}