package lesson10.text;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;


public class TextStat {
        public static void main(String[] args) throws IOException  {
            String fileName = "C:\\Users\\Игорь\\IdeaProjects\\lessons\\resources\\wp.txt";
            String str = Files.readString(Paths.get(fileName));
        //    System.out.println(str);
            str = str.toLowerCase();
            str = str.replaceAll("\\W", " ");
            System.out.println(str);
            Map<String, Integer> map = new HashMap<>();

            for(String s: str.split(" ")) {
                if(map.containsKey(s)) {
                    map.put(s, map.get(s) + 1);
                }
                else {

                    map.put(s, 1);

                }

            }
            Map<String, Integer> map5 = new HashMap<>();

            for(String s: str.split(" ")) {
                if(map5.containsKey(s)) {
                    map5.put(s, map5.get(s) + 1);
                }
                else {

                    map5.put(s, 1);

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
            Map<Character,Integer> map3 = new HashMap<>();
            char[] mass = str.replaceAll("\\s+","").toCharArray();
            for (int i = 0; i<mass.length; i++){
                char lett = mass[i];
                if(map3.containsKey(lett)) {

                    map3.put(lett, map3.get(lett) + 1);
                }
                else {

                    map3.put(lett, 1);

                }

            }
            Map<String, Integer> newMap = new TreeMap(Collections.reverseOrder());

            map.entrySet().stream().sorted(MyComparator.comparing(Map.Entry::getValue))
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
            map3.entrySet().stream().sorted(MyComparator.comparing(Map.Entry::getValue))
                    .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));

            map.remove("");
            System.out.println(map);
          //  System.out.println(map2);
           // System.out.println(map3);
        }
    }
class MyComparator implements Comparator {
    Map map;

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }

    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
                (c1, c2) -> keyExtractor.apply(c2).compareTo(keyExtractor.apply(c1));
    }
}

