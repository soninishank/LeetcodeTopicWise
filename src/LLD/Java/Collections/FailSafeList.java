package LLD.Java.Collections;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

// it will not throw an error
public class FailSafeList {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("", 11);
        list.add("a");
        list.add("b");

        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
            list.add("c");
        }

        System.out.println("complete list " + list);
    }
}
