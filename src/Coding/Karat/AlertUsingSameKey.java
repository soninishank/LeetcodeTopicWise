package Coding.Karat;

import java.util.*;

// https://leetcode.com/problems/alert-using-same-key-card-three-or-more-times-in-a-one-hour-period/
public class AlertUsingSameKey {
    public List<String> alertNames(String[][] str) {
        HashMap<String, List<Integer>> hashMap = new HashMap<>();
        for (String[] s1 : str) {
            hashMap.putIfAbsent(s1[0], new ArrayList<>());
            hashMap.get(s1[0]).add(Integer.valueOf(s1[1]));
        }
        System.out.println(hashMap);
        Iterator<Map.Entry<String, List<Integer>>> iter = hashMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, List<Integer>> entry = iter.next();
            List<Integer> list = entry.getValue();
            Collections.sort(list);
            boolean flag = false;
            for (int i = 2; i < list.size(); i++) {
                if (list.get(i) - list.get(i - 2) <= 60) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                iter.remove();
            }
        }
        System.out.println(hashMap);
        return null;
    }


    public static void main(String[] args) {
        String[][] str = {{"Paul", "1355"}, {"Jennifer", "1910"}, {"Jose", "835"}, {"Jose", "830"}, {"Paul", "1315"}, {"Chloe", "0"}, {"Chloe", "1910"}, {"Jose", "1615"}, {"Jose", "1640"}, {"Paul", "1405"}, {"Jose", "855"}, {"Jose", "930"}, {"Jose", "915"}, {"Jose", "730"}, {"Jose", "940"}, {"Jennifer", "1335"}, {"Jennifer", "730"}, {"Jose", "1630"}, {"Jennifer", "5"}, {"Chloe", "1909"}, {"Zhang", "1"}, {"Zhang", "10"}, {"Zhang", "109"}, {"Zhang", "110"}, {"Amos", "1"}, {"Amos", "2"}, {"Amos", "400"}, {"Amos", "500"}, {"Amos", "503"}, {"Amos", "504"}, {"Amos", "601"}, {"Amos", "602"}, {"Paul", "1416"},};
        List<String> list = new AlertUsingSameKey().alertNames(str);

    }
}
