package IO.Compression;

import java.io.*;
import java.util.zip.GZIPOutputStream;

public class GZIPCompressor {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("abasdawfawdc");
        BufferedOutputStream bout = new BufferedOutputStream(
                new GZIPOutputStream(
                        new FileOutputStream(
                                new File("gzipped.gz")
                        )
                ));
        int nextByte;
        while ((nextByte = reader.read()) != -1) {
            bout.write(nextByte);
        }
        bout.close();
    }
}
