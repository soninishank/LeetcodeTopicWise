package Coding.Everlaw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AverageVictory {

    private HashMap<String, List<Integer>> listHashMap = new HashMap<>();
    private HashMap<String, Set<String>> adjList = new HashMap<>();
    //  private HashMap<String, String> adjList = new HashMap<>();
    private HashMap<String, Double> largestAverageMargin = new HashMap<>();

    private void readAFile() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("src/Coding/Everlaw/sports.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] s = line.split(" ");
                String firstPlayer = s[0];
                int firstPlayerScore = Integer.parseInt(s[1]);
                String secondPlayer = s[2];
                int secondPlayerScore = Integer.parseInt(s[3]);
                if (firstPlayerScore > secondPlayerScore) {
                    listHashMap.putIfAbsent(s[0], new ArrayList<>());
                    listHashMap.get(s[0]).add(firstPlayerScore - secondPlayerScore);

                    adjList.putIfAbsent(firstPlayer, new HashSet<>());
                    adjList.get(firstPlayer).add(secondPlayer);
                } else {
                    listHashMap.putIfAbsent(s[1], new ArrayList<>());
                    listHashMap.get(s[1]).add(secondPlayerScore - firstPlayerScore);

                    adjList.putIfAbsent(secondPlayer, new HashSet<>());
                    adjList.get(secondPlayer).add(firstPlayer);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(adjList);
        // o=[p, q, c, d, e, v, g, i, j, k, m]
        // p=[b, t, f, v, w, g, l, m, n, o]
        // A B C D E F G H -> source nodes
        // find all paths from source
        // o -> p -> b
        // o -> p -> t -> c -> d -> o -> both can dominate each other

        //System.out.println(listHashMap);
    }

    private Map.Entry<String, Double> calculateAverageMargin() {
        for (String str : listHashMap.keySet()) {
            List<Integer> list = listHashMap.get(str);
            if (list.size() > 0) {
                double sum = list.stream().mapToInt(Integer::intValue).sum();
                double average = sum / list.size();
                largestAverageMargin.put(str, average);
            }
        }
        Map.Entry<String, Double> entry = largestAverageMargin.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get();
        System.out.println(entry.getKey() + "  " + entry.getValue());
        return entry;
    }

    HashMap<String, List<String>> competitiveMap = new HashMap<>();

    private void getCompetitiveAgainst() {
        for (String str : adjList.keySet()) {
            HashSet<String> visitedSet = new HashSet<>();
            competitiveMap.putIfAbsent(str, new ArrayList<>());
            visitedSet.add(str);
            if (adjList.get(str).size() > 0) {
                for (String str1 : adjList.get(str)) {
                    applyDFS(adjList, str1, visitedSet, str, competitiveMap);
                }
            }
        }
        System.out.println(competitiveMap);
    }

    void applyDFS(HashMap<String, Set<String>> adjList, String source, HashSet<String> visitedSet, String target, HashMap<String, List<String>> arrayList) {
        if (source.equals(target)) {
            return;
        }
        if (visitedSet.contains(source)) {
            return;
        }
        competitiveMap.get(target).add(source);
        visitedSet.add(source);
        if (adjList.get(source).size() > 0) {
            for (String neighbour : adjList.get(source)) {
                if (visitedSet.contains(neighbour)) {
                    continue;
                }
                applyDFS(adjList, neighbour, visitedSet, target, arrayList);
            }
        }
        return;
    }

    public static void main(String[] args) {
        AverageVictory averageVictory = new AverageVictory();
        averageVictory.readAFile();// reading a file
        Map.Entry<String, Double> marginKey = averageVictory.calculateAverageMargin();
        System.out.println(marginKey);

        averageVictory.getCompetitiveAgainst();
    }


}
