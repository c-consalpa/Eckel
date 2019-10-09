package IO.NIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Scanner;

public class StringSearch {
    public static void main(String[] args) throws FileNotFoundException {
        String str = "abc";
        System.out.println(Arrays.toString(str.getBytes()));
        int B_SIZE = 1024 * 4;
        File f = new File("searchForString");
        RandomAccessFile rf = new RandomAccessFile(f,"rw");
        FileChannel fc = rf.getChannel();
        ByteBuffer.allocate(B_SIZE);
//        fc.read()



    }
}
