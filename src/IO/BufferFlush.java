package IO;

import java.io.BufferedOutputStream;
import java.io.IOException;

public class BufferFlush {
    public static void main(String[] args) {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);

        try {
            bufferedOutputStream.write(99);
            bufferedOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
