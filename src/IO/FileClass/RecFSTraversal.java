package IO.FileClass;

import IO.IO_VARS;

import java.io.File;
import java.util.*;

public class RecFSTraversal {
    static ArrayList<String> res = new ArrayList<>();
    static int depth = 0;


    public static void main(String[] args) {
        File f = new File(IO_VARS.BASE_DIR, "recursive");

        traverseDir(f);
        System.out.println(res);
    }


    public static List<String> traverseDir(File startDir) {

        File[] dirs = startDir.listFiles();
        if (dirs.length > 0) {
            for (int i = 0; i < dirs.length; i++) {
                if(dirs[i].isFile()) res.add(dirs[i].getName());
                if (dirs[i].isDirectory()) {
                    traverseDir(dirs[i]);
                }
            }
        }
        return null;
    }
}


