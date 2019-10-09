package IO.NIO;

import IO.IO_VARS;

import java.io.*;
// copies files byte by byte via in/out streams.
// benchmark: 950M bytes: 29 sec (10 times slower)
public class SimpleFileCopy_Streams {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
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

        try (
                BufferedInputStream bfin = new BufferedInputStream(
                        new FileInputStream(src)
                );

                BufferedOutputStream bfout = new BufferedOutputStream(
                        new FileOutputStream(dst)
                );
                ) {
            int bf;
            while ((bf = bfin.read()) != -1) {
                bfout.write(bf);
            }

        } catch (IOException e) {
            System.err.println(e);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
