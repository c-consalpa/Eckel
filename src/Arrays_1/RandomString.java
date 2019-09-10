package Arrays_1;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomString {
    public static void main(String[] args) {

        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        int success = 0;
        String str2Compare = null;

        for (int i = 0; i < 10000; i++) {
            String str2test = genRandomString(3);
            Matcher matcher = pattern.matcher(str2test);
            if (matcher.matches()) success++;
            if (str2Compare == null) {
                str2Compare = str2test;
                continue;
            }
           if (str2test.equals(str2Compare)) try {
               throw new Exception("AAAFRG");
           } catch (Exception e) {
               e.printStackTrace();
           }


        }


    }

    static String genRandomString(int len) {
        StringBuilder builder = new StringBuilder();


        for (int i = 0; i < len; i++) {
            builder.append(generateChar());
        }


        return builder.toString();
    }

    static public char generateChar() {
        char generatedChar;
        int numOfCharsASCII = 60;

        Random random = new Random();
        int randomNumber = random.nextInt(60);

        if (randomNumber < 10) {
            generatedChar = (char) (48 + randomNumber);
        } else if (randomNumber >= 10 && randomNumber < 36) {
            generatedChar = (char) (48 + 7 + randomNumber);
        } else if (randomNumber >= 35 && randomNumber < numOfCharsASCII) {
            generatedChar = (char) (48 + 7 + 6 + randomNumber);
        } else {
            return '-';
        }

        return generatedChar;
    }
}
