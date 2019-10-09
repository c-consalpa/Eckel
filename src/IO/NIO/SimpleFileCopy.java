package IO.NIO;

import IO.IO_VARS;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

// copies files by direct interaction with the buffer.
// benchmark: 950M bytes: 3.5 sec
public class SimpleFileCopy {
    static long start = System.currentTimeMillis();
    public static void main(String[] args) {
        File src = new File("D:\\Downloads\\EDFX-WindowsBitDefender-Engineering_with_status.exe");
        File dst = new File(IO_VARS.BASE_DIR + "\\copySpeedComparison\\EDFX-WindowsBitDefender-Engineering_with_status.exe");
        if (!dst.exists()) {
            try {
                dst.getParentFile().mkdirs();
                dst.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        int B_SIZE = 1024;
        try {
            RandomAccessFile srcFile = new RandomAccessFile(src, "r");
            RandomAccessFile dstFile = new RandomAccessFile(dst, "rw");
            FileChannel srcChannel = srcFile.getChannel();
            FileChannel dstChannel = dstFile.getChannel();
            ByteBuffer bf = ByteBuffer.allocate(B_SIZE);

            while (srcChannel.read(bf) != -1) {
                bf.flip();
                dstChannel.write(bf);
                bf.clear();
            }
            System.out.println(dstChannel.size() / 1048576);
            dstChannel.close();
            srcChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
