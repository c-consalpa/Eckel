package Procedural;

public class StringMultiOccurrence {
    public static void main(String[] args) {
        String str = "asdasd";
        find(str, "sd");

    }

    public static void find(String src, String sub) {
        if (src == null || src.isEmpty() || src.length() < sub.length()) return;
        int matchIndex = 0;
        int cnt = 0;

        while ((matchIndex = src.indexOf(sub, matchIndex))!= -1) {
            matchIndex++;

             cnt++;
}

    System.out.println(cnt);
    }
}
