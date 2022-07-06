package Coding.Stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingCharacterInStreamOfCharacters {

    HashMap<Character, Integer> freqMap = new HashMap<>();
    Queue<Character> queue = new LinkedList<>();

    private void printFirstNonRepeatingCharactersInStream(char[] stream) {
        for (int i = 0; i < stream.length; i++) {
            freqMap.put(stream[i], freqMap.getOrDefault(stream[i], 0) + 1);
            if (freqMap.get(stream[i]) == 1) {
                queue.add(stream[i]);
            }
            while (!queue.isEmpty()) {
                char c = queue.peek();
                if (freqMap.get(c) == 1) {
                    break;
                } else {
                    queue.remove();
                }
            }
            if (queue.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(queue.peek() + " ");
            }
        }
    }

}
