package IO;

import java.io.*;
import java.util.zip.CheckedInputStream;

public class FileOutputShortcut {
    public static void main(String[] args) {
        StringReader stringReader = new StringReader("123sdasd");
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("pw"));
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

printWriter.println("12312312");
printWriter.println("12312312");
printWriter.println("12312312");

printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}