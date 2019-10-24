package Procedural;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringMultiOccurrence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("data.txt"));
        String line;


        while((line = bf.readLine()) != null) {
//                                                                    abcdefghikqaz
            Map<Integer, String> result = searchOccurrences(line, "g");

            System.out.println(result);
        }




    }




    private static Map<Integer, String> searchOccurrences(String line, String pattern) {
        if (line.isEmpty() || line.length() < pattern.length()) return null;
        Map<Integer, String> occurrenceMap = new LinkedHashMap<>();
        int matchIndex = 0;
        int cnt = 0;
//search for string occurrance in a line
        while ((matchIndex = line.indexOf(pattern, matchIndex))!= -1) {
            String surroundingStr = getSurroundingString(line, pattern, matchIndex);

             occurrenceMap.put(matchIndex, "");
//  Once we find "abc" => move 3 indexes forward;

            matchIndex += pattern.length();
            cnt++;
        }
        return occurrenceMap;
    }

    private static String getSurroundingString(String line, String pattern, int matchIndex) {
//        The method returns the pattern with nearby surrounding chars, e.g.: abcd*pattern*zyz...
        StringBuilder sb = new StringBuilder();
//      defines how much chars to show before and after the pattern
        int bounds = 5;

//        get chars before pattern
        int charsbefore = matchIndex;
        if (charsbefore > bounds) {
            sb.append("...");
            sb.append(line, (matchIndex - bounds), matchIndex);
        } else {
            sb.append(line, 0, charsbefore);
        }

//add pattern itself
        sb.append("*" + pattern + "*");

//      get chars after the pattern
        int charsafter = line.length() - (matchIndex + pattern.length());
        if (charsafter <= bounds) {
            sb.append(line, (matchIndex + pattern.length()), line.length());
        } else {
            sb.append(line, (matchIndex + pattern.length()), (matchIndex + pattern.length() + bounds));
            sb.append("...");
        }

        return sb.toString();
    }
}
