package IO.FileClass;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File f = new File("D:\\Downloads");
        Pattern pattern = Pattern.compile(".*\\.zip$");
        String[] dirContents = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Matcher matcher = pattern.matcher(name);
                return matcher.matches();
            }
        });
        System.out.println(Arrays.toString(dirContents));
    }
}
