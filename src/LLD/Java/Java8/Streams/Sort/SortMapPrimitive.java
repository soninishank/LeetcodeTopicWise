package LLD.Java.Java8.Streams.Sort;

import java.util.*;

public class SortMapPrimitive {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("eight", 8);
        map.put("four", 4);
        map.put("ten", 10);
        map.put("two", 2);

        // Collections.sort expects list as an argument
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        List<Map.Entry<String, Integer>> listEntry = new ArrayList<>(entries);
        Collections.sort(listEntry, (o1, o2) -> o1.getKey().compareTo(o2.getKey())); // sort by key -System.out.println(listEntry);
        Collections.sort(listEntry, ((o1, o2) -> o1.getValue().compareTo(o2.getValue()))); // sort by value

        // using streams
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);
        System.out.println("$$$$$$$$$$$$$$$$");
        map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);

    }
}
