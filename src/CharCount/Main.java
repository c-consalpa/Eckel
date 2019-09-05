package CharCount;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (
                InputStream in = new FileInputStream("D:\\java\\testData\\charCount.txt");
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                ){

            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                sb.append(line + " ");
                line = reader.readLine();
            }

            System.out.println(sb.toString());
            String[] arr = (sb.toString().split(" "));
            List<String> list = new ArrayList<>();
            list.addAll(Arrays.asList(arr));
            System.out.println(list);
            System.out.println("Size " + list.size());

            Map<String, Integer> map = new HashMap<>();
            for(String listElement : list) {

               if (map.containsKey(listElement)) {
                   map.put(listElement, map.get(listElement) + 1);
               } else {
                   map.put(listElement, 1);
               }
            }


            System.out.println("MAP");
            System.out.println(map);








        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
