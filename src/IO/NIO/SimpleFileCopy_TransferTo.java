package IO.NIO;

import IO.IO_VARS;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


// copies files by direct interaction with the buffer.
// benchmark: 950M bytes: ~ 1.0 s
 public class SimpleFileCopy_TransferTo {
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
            srcChannel.transferTo(0,srcChannel.size(),dstChannel);
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
