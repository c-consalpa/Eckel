package Basics;

public class Daemons {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            Thread t1 = new Thread(new DaemonWorker(i));
            t1.setDaemon(true);
            t1.start();
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class DaemonWorker implements Runnable {
int id;
    public DaemonWorker(int i) {
        this.id = i;
    }

    @Override
    public void run() {
        System.out.println("ID: " + id + "; " + this);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("ID: " + id + "; END");


    }
}