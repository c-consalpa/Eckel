package IO.FileClass;

import IO.IO_VARS;

import java.io.File;
import java.util.*;

public class RecFSTraversal {
    static ArrayList<String> res = new ArrayList<>();
    static int depth = 0;


    public static void main(String[] args) {
        File f = new File(IO_VARS.BASE_DIR, "recursive");

        System.out.println(traverseDir(f));

    }

//  Returns directory structure as String
//    public static String traverseDir(File startDir) {
//        String result = "";
//        File[] files = startDir.listFiles();
//        if (files.length > 0) {
//            String filesInDirectory = "";
//            for (int i = 0; i < files.length; i++) {
//                if (files[i].isDirectory()) {
//                    result += traverseDir(files[i]);
//                } else {
//                    filesInDirectory += files[i].getName();
//                    filesInDirectory += ", ";
//                }
//            }
//
//            return result + filesInDirectory;
//        } else {
//            return "* ";
//        }
//
//    }

//    Returns File[]:
public static List<File> traverseDir(File startDir) {
    List<File> result = new ArrayList<>();
    File[] files = startDir.listFiles();
        if (files.length == 0) {
//            break the loop if directory is empty
            return null;
        }

        List<File> filesInDirectory = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                List<File> tmp = traverseDir(files[i]);
                if (tmp != null) result.addAll(tmp);
            } else {
                filesInDirectory.add(files[i]);
            }
        }
//        harvesitng files accumulated in *for* loop:
        result.addAll(filesInDirectory);
        return result;
}

}


