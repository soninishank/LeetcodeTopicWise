package LLD.Java.Java8.Streams.Sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortListPrimitive {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(2);
        list.add(10);
        list.add(5);
//        Collections.sort(list);
//        Collections.reverse(list);
        list.stream().sorted().forEach(s -> System.out.print(s + " "));// ascending
        System.out.println();
        list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " ")); // descending
    }
}
