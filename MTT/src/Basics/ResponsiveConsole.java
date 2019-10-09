package Basics;

import java.util.Scanner;


public class ResponsiveConsole {
    public static void main(String[] args) {
        mUI ui = new mUI(new UIOutputSimulation());
        ui.start();
        new Reader().start();
    }
}

class Reader extends Thread {
//    TODO Fix input reset on ui heartbeat tick;
    public Reader() {
        super(() -> {
            Scanner scanner = new Scanner(System.in);
            while(true) {
                String str = scanner.nextLine();
                System.out.println("calculating....");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("result:" + str);
            }

        });
    }
}


class mUI extends Thread {
    public mUI(Runnable target) {
        super(target);
    }
}

class UIOutputSimulation implements Runnable {

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}