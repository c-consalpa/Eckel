package IO.NIO;

import IO.FileOutputShortcut;
import IO.IO_VARS;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOTackle {
    public static void main(String[] args) {
        File dst = new File(IO_VARS.BASE_DIR, "NIO\\NioTackle");

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(dst, "rw");
            FileChannel fc = randomAccessFile.getChannel();
            ByteBuffer bf = ByteBuffer.wrap(new byte[] {65, 85, 77});
            fc.write(bf);
            bf.clear();

            fc.close();


            RandomAccessFile randomAccessFile1 = new RandomAccessFile(dst, "rw");
            FileChannel fc1 = randomAccessFile1.getChannel();
            ByteBuffer bf1 = ByteBuffer.wrap(new byte[] {69});
            fc1.position((int) fc1.size()+ 1000);
            fc1.write(bf1);
            bf1.clear();

            fc1.close();
//            FileOutputStream fileOutputStream = new FileOutputStream(dst);
//            FileChannel fc = fileOutputStream.getChannel();
//            System.out.println(fc.size());
//            ByteBuffer bf = ByteBuffer.allocate(3);
//            bf.put(new byte[] {65, 85, 120});
////    won't work without this:
//            bf.clear();
//            fc.write(bf);





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
