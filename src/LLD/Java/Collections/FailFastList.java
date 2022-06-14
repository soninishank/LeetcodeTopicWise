package LLD.Java.Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Exception in thread "main" java.util.ConcurrentModificationException
public class FailFastList {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
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
