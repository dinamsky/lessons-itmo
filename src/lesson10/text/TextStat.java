package lesson10.text;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    public class TextStat
    {
        public static void main(String[] args) throws IOException {
            String fileName = "C:\\Users\\Игорь\\IdeaProjects\\lessons\\resources\\wp.txt";
            String str = Files.readString(Paths.get(fileName));
        //    System.out.println(str);
            str = str.toLowerCase();
            str = str.replaceAll("\\W", " ");
            System.out.println(str);
            Map<String, Integer> map = new HashMap<>();
          int n = 1;
            for(String s: str.split(" ")) {
                if(map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {

                    map.put(s, 1);

                }

            }

            Map<Integer, List<String>> map2 = new HashMap<>();
            for (String word : str.split(" ")) {
                int key = word.length();
                List<String> list2 = map2.get(key);
                if (list2 == null) {
                    list2 = new ArrayList<>();
                    map2.put(key, list2);
                }
                list2.add(word);
            }

            map.remove("");
            System.out.println(map);
            System.out.println(map2);
        }
    }

