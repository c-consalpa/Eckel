package IO.NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedBuffers {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("bigFile", "rw");
        FileChannel fc = randomAccessFile.getChannel();
        int B_SIZE = 0x8FFFFFF;
        ByteBuffer bf = ByteBuffer.allocate(0x8FFFFFF);

        bf.position(B_SIZE - 1);
                bf.put((byte) 65);
        bf.clear();

        fc.write(bf);

    }
}
