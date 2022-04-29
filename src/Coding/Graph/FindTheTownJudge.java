package Coding.Graph;

// always the number of columns is 2
public class FindTheTownJudge {

    private int findJudge(int n, int[][] trust) {
        int[] inbound = new int[n + 1];
        int[] outbound = new int[n + 1];
        for (int[] arr : trust) {
            inbound[arr[1]]++;
            outbound[arr[0]]++;
        }
        for (int i = 0; i <= n; i++) {
            if (outbound[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] trust = {{1, 2}, {2, 3}};
        int judge = new FindTheTownJudge().findJudge(n, trust);
        System.out.println(judge);
    }
}
