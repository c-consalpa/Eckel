package IO.NIO;

import IO.IO_VARS;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class DataTypeConversion {
    public static void main(String[] args) throws IOException {
        File dst = new File(IO_VARS.BASE_DIR + "\\dataConversion\\test");
        if (!dst.exists()) {
            try {
                dst.getParentFile().mkdirs();
                dst.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fileOutputStream = new FileOutputStream(dst);
        FileChannel fc = fileOutputStream.getChannel();
        ByteBuffer bf = ByteBuffer.allocate(64);
        bf.putChar('C');
        bf.putChar('B');
        bf.putChar('A');
        bf.clear();
        fc.write(bf);

        fc.close();

        FileInputStream fileInputStream = new FileInputStream(dst);
        FileChannel fic = fileInputStream.getChannel();
        ByteBuffer bfIn = ByteBuffer.allocate(64);
        fic.read(bfIn);
        bfIn.flip();
        while (bfIn.hasRemaining()) {
            System.out.println(bfIn.getLong());
        }
    }
}
