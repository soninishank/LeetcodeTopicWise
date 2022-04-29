import java.util.List;
import java.util.Map;

public class VotingSystem {

    // implement this method for Part 1
    public static String getPluralityWinner(Map<List<String>, Integer> ballots) {
        String result = "";
        int max = Integer.MIN_VALUE;
        for (Map.Entry<List<String>, Integer> listIntegerEntry : ballots.entrySet()) {
            Integer value = listIntegerEntry.getValue();
            if (max < value) {
                max = value;
                result = listIntegerEntry.getKey().get(0);
            }
        }
        return result;
    }


    // implement this method for Part 2
    public static String getRankedChoiceWinner(Map<List<String>, Integer> ballots) {
        return null;
    }

    public static void main(String args[]) throws Exception {
        // Sample Test Case
        Map<List<String>, Integer> sample = Map.of(List.of("A", "B", "C"), 4, List.of("B", "C", "A"), 3, List.of("C", "B", "A"), 2);

        // Determine plurality winner (Part 1)
        System.out.println("The plurality winner is: " + getPluralityWinner(sample));
        // todo: add additional test cases for Part 1 here


        // Determine ranked choice winner (Part 2)
        System.out.println("The ranked choice winner is: " + getRankedChoiceWinner(sample));
        // todo: add additional test cases for Part 2 here


    }
}
