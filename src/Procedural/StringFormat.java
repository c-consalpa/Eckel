package Procedural;

import java.util.Formatter;

public class StringFormat {
    public static void main(String[] args) {
// wont work:
//   String str0 = "asqwdqwascascas";
//        String str1 = "123123123123";
//        String str2 = "xyz";
//        String str3 = "abbbbbbbbbbb";
//
//        String res = String.format(str0, str1, str2, str3, "%1s5", "%2s5", "%3s5", "%4s5");
//        System.out.println(res);

        StringBuilder sbuf = new StringBuilder();
        System.out.printf("|%3$-20s|", "abc", "def", "ghi");







    }
}
