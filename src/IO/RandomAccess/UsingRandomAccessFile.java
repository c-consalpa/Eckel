package IO.RandomAccess;

import IO.IO_VARS;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class UsingRandomAccessFile {
    static String file = "rtest.dat";
    static void display() throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "r");
        for(int i = 0; i < 3; i++)
            System.out.println("Value " + i + ": " + rf.readDouble());
        System.out.println(rf.readUTF());
        rf.close();
    }
    public static void main(String[] args) throws IOException {
        RandomAccessFile rf = new RandomAccessFile(file, "rw");
        for(int i = 0; i <3; i++) rf.writeDouble(i*1.414);

        rf.writeUTF("The end of the file");
        rf.writeInt(12);
        rf.close();
        display();
        System.out.println("________");
        rf = new RandomAccessFile(file, "rw");
 System.out.println("FIle pointer:" + rf.getFilePointer());
rf.seek(3*8);

//        System.out.println(rf.readUTF() + "AAAAA");
        rf.seek(45);
        System.out.println("FIle pointer:" + rf.getFilePointer());
        System.out.println(rf.readInt());
        rf.close();

//        display();
    }
}
