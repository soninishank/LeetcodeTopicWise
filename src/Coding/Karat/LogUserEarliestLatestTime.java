package Coding.Karat;

import java.util.HashMap;

public class LogUserEarliestLatestTime {

    public HashMap<Integer, int[]> getUserLatestAccessTime(String[][] str) {
        HashMap<String, minMax> hashMap = new HashMap<>();
        for (String[] s1 : str) {
            if (hashMap.containsKey(s1[1])) {
                minMax minMax = hashMap.get(s1[1]);
                int min = Math.min(minMax.min, Integer.parseInt(s1[0]));
                int max = Math.max(minMax.max, Integer.parseInt(s1[0]));
                hashMap.put(s1[1], new minMax(min, max));
            } else {
                hashMap.put(s1[1], new minMax(Integer.parseInt(s1[0]), Integer.parseInt(s1[0])));
            }
        }
        System.out.println(hashMap);
        return null;
    }

    public static void main(String[] args) {
        String[][] str = {
                {"58523", "user_1", "resource_1"},
                {"62314", "user_2", "resource_2"},
                {"54001", "user_1", "resource_3"},
                {"200", "user_6", "resource_5"},
                {"215", "user_6", "resource_4"},
                {"54060", "user_2", "resource_3"},
                {"53760", "user_3", "resource_3"},
                {"58522", "user_22", "resource_1"},
                {"53651", "user_5", "resource_3"},
                {"2", "user_6", "resource_1"},
                {"100", "user_6", "resource_6"},
                {"400", "user_7", "resource_2"},
                {"100", "user_8", "resource_6"},
                {"54359", "user_1", "resource_3"},
        };
        HashMap<Integer, int[]> userLatestAccessTime = new LogUserEarliestLatestTime().getUserLatestAccessTime(str);
        System.out.println(userLatestAccessTime);
    }

    class minMax {
        int min;
        int max;

        public minMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            return "{" +
                    "" + min +
                    "," + max +
                    '}';
        }
    }


}

