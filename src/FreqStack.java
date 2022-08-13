import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {
    int maxFreq;
    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;

    public FreqStack() {
        freq = new HashMap<Integer, Integer>();
        group = new HashMap<>();
    }

    public void push(int val) {
        int totalCount = freq.getOrDefault(val, 0) + 1;
        freq.put(val, totalCount);
        if (totalCount > maxFreq) {
            maxFreq = totalCount;
        }
        group.putIfAbsent(totalCount, new Stack<>());
        group.get(totalCount).add(val);
    }

    public int pop() {
        int key = group.get(maxFreq).pop();
        freq.put(key, freq.getOrDefault(key, 0) - 1);
        if (group.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return key;
    }

    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].
    }
}
