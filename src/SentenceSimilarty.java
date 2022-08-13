import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SentenceSimilarty {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, String[][] similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        HashMap<String, List<String>> hashmap = new HashMap<>();
        for (String[] list1 : similarPairs) {
            hashmap.putIfAbsent(list1[0], new ArrayList<>());
            hashmap.get(list1[0]).add(list1[1]);

            hashmap.putIfAbsent(list1[1], new ArrayList<>());
            hashmap.get(list1[1]).add(list1[0]);
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) {
                continue;
            } else {
                if (!applyDFS(sentence1[i], sentence2[i], hashmap, new HashSet<>())) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean applyDFS(String source, String target, HashMap<String, List<String>> hashmap, HashSet<String> visitedSet) {
        visitedSet.add(source);
        if (hashmap.containsKey(source)) {
            for (String str : hashmap.get(source)) {
                if (visitedSet.contains(str)) {
                    continue;
                } else if (str.equals(target)) {
                    return true;
                } else if (applyDFS(str, target, hashmap, visitedSet)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] str1 = {"great", "acting", "skills"};
        String[] str2 = {"fine", "drama", "talent"};
        String[][] similarPairs = {{"great", "good"}, {"fine", "good"}, {"drama", "acting"}, {"skills", "talent"}};
        boolean b = new SentenceSimilarty().areSentencesSimilarTwo(str1, str2, similarPairs);
        System.out.println(b);
    }
}
