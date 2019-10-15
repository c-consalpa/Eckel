package Procedural;

public class BasicRec {
    public static void main(String[] args) {
//        System.out.println(countRec(5));
        System.out.println(countRecStr(4));
    }

    private static String countRecStr(int i) {
        String tmp = "|" + i + "|+";
        if (i == 0) return "end";
        return tmp + countRecStr(i - 1);
    }

    //    factorial
    private static int countRec(int i) {
        if (i == 0) return 1;
            return i * countRec(i - 1);

    }

//    StringConcat
}
