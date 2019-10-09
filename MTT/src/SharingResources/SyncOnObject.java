package SharingResources;

public class SyncOnObject {
    static Monitor m = new Monitor();
    static Monitor m_fake = new Monitor();

    public static void main(String[] args) {

    qTask qTask = new qTask();
    new Thread(qTask).start();
    new Thread(qTask).start();
    new Thread(qTask).start();


    }
}

class qTask implements Runnable {

    @Override
    public void run() {
        f();
        g();
    }

    private synchronized void g() {
        for (int i = 0; i < 10; i++) {
            System.out.println("g " + Thread.currentThread());
        }
    }

    public synchronized void f() {
        for (int i = 0; i < 10; i++) {
            System.out.println("f " + Thread.currentThread());
        }

    }
}


class Monitor {

}