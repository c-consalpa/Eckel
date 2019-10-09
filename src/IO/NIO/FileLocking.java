package IO.NIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLocking {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("fileLocking");
        FileChannel fc = fileOutputStream.getChannel();
        FileLock fl = fc.tryLock();

        if (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            fl.release();
//            System.out.println("released");
//        }

        }
//        System.out.println("locked;");
    }
}