import java.util.Arrays;
import java.util.PriorityQueue;

public class FractionalKnapsack {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue<Ratio> priorityQueue = new PriorityQueue<>((a, b) -> Double.compare(b.exactValue, a.exactValue));
        for (int i = 0; i < boxTypes.length; i++) {
            double result = (double) boxTypes[i][1] / (double) boxTypes[i][0];
            priorityQueue.add(new Ratio(boxTypes[i][1], boxTypes[i][0], result));
        }
        while (!priorityQueue.isEmpty()) {
            Ratio poll = priorityQueue.poll();
            if (poll.weight < truckSize) {
            } else {

            }
        }

        System.out.println(Arrays.toString(priorityQueue.toArray()));
        return -1;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {2, 2}, {3, 1}};
        int i = new FractionalKnapsack().maximumUnits(arr, 4);
        System.out.println(i);
    }

    class Ratio {
        private final int profit;
        private final int weight;
        private final double exactValue;

        public Ratio(int profit, int weight, double exactValue) {
            this.profit = profit;
            this.weight = weight;
            this.exactValue = exactValue;
        }

        @Override
        public String toString() {
            return "Ratio{" +
                    "profit=" + profit +
                    ", weight=" + weight +
                    ", exactValue=" + exactValue +
                    '}';
        }
    }
}


