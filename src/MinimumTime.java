import java.util.*;

public class MinimumTime {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] arr : edges) {
            adjList.get(arr[0]).add(arr[1]);
            adjList.get(arr[1]).add(arr[0]);
        }
        Set<Integer> visitedSet = new HashSet<>();
        return applyDFS(adjList, visitedSet, hasApple, 0);
    }

    private int applyDFS(List<List<Integer>> adjList, Set<Integer> visitedSet, List<Boolean> list, int source) {
        visitedSet.add(source);
        int res = 0;
        for (int child : adjList.get(source)) {
            if (visitedSet.contains(child)) continue;
            res += applyDFS(adjList, visitedSet, list, child);
        }

        if ((res > 0 || list.get(source)) && source != 0) res += 2;

        return res;
    }

    public static void main(String[] args) {
        int[][] arr = {{0,1},{0,2},{1,4},{1,5},{2,3},{2,6}};
        List<Boolean> booleans = Arrays.asList(false, false, true, false, true, true, false);
        int i = new MinimumTime().minTime(7, arr, booleans);
        System.out.println(i);
    }
}
