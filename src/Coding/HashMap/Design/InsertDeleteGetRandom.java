package Coding.HashMap.Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

// Coding.HashMap insertion, deletion, the search takes O(1) constant time
// List - removal from last index is - O(1)
public class InsertDeleteGetRandom {
    HashMap<Integer, Integer> hashMap;
    List<Integer> list;
    Random random;

    public InsertDeleteGetRandom() {
        hashMap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (!hashMap.containsKey(val)) {
            hashMap.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        if (hashMap.containsKey(val)) {
            int listIndex = hashMap.get(val);
            int lastElement = list.get(list.size() - 1);
            list.set(listIndex, lastElement);
            hashMap.put(lastElement, listIndex); // we are putting list index which is correct because we are setting on list index

            // remove
            list.remove(list.size() - 1);
            hashMap.remove(val);
            return true;
        }
        return false;
    }

    public int getRandom() {
        int randomElement = list.get(random.nextInt(list.size()));
        return randomElement;
    }
}