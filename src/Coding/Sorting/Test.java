package Coding.Sorting;

import java.util.*;
import java.util.stream.Collectors;

class Test {

    static HashSet<String> visitedSet = new HashSet<>();

    void printInOrder(HashMap<String, List<String>> hashMap) {
        if (hashMap.size() == 0) {
            return;
        }
        // O(N)
        for (String key : hashMap.keySet()) {
            int val = hashMap.get(key).size();
            if (val > 0) {
                applyDFS(hashMap, key, visitedSet);
            }
        }
    }

    void applyDFS(HashMap<String, List<String>> hashMap, String element, HashSet<String> visitedSet) {
        if (visitedSet.contains(element)) {
            return;
        }
        visitedSet.add(element);
        for (int i = 0; i < hashMap.get(element).size(); i++) {
            String str = hashMap.get(element).get(i);
            if (hashMap.containsKey(str) && !visitedSet.contains(str)) {
                applyDFS(hashMap, str, visitedSet);
            }
        }
        System.out.println(element);
    }

    void getDistinct() {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5);
        List<Integer> collect = list.stream()
                .filter(name -> Collections.frequency(list, name) == 1)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    void getDuplicates() {
        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 4, 5, 5);
        Set<Integer> collect = list.stream()
                .filter(person -> Collections.frequency(list, person) > 1)
                .collect(Collectors.toSet());
        System.out.println(collect);
    }


    public static void main(String[] args) {
//        HashMap<String, List<String>> hashMap = new HashMap<>();
//        hashMap.put("apple", Arrays.asList("mango", "banana"));
//        hashMap.put("banana", Arrays.asList("strawberry"));
//        hashMap.put("strawberry", Arrays.asList("blueberry"));
//        hashMap.put("blueberry", Arrays.asList("mango"));
//        hashMap.put("mango", Arrays.asList(""));
//        new Test().printInOrder(hashMap);

        new Test().getDistinct();
        new Test().getDuplicates();
    }
}
//              apple
// mango                            banana
//                                        strawberry
//                                                  blueberry


// apple
// banana
// strawberry
// blueberry
// mango

// mango
// blueberry
// strawberry
// banana
// apple