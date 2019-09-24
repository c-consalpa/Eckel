package IO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class IOStreamsTest {
    static byte[] raw;
    public static void main(String[] args) {
        raw = "qwertyuiop[]asdfghjkl;'zxcvbnm,.1234567890".getBytes(StandardCharsets.UTF_16BE);
        //        OutputStream out = null;
        try (
                BufferedOutputStream out = new BufferedOutputStream(
                        new FileOutputStream(
                                new File(IO_VARS.BASE_DIR, "IOStreams\\out")))
                ) {

            out.write(raw);




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
