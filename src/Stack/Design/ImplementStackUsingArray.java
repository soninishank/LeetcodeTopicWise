package Stack.Design;

import java.util.ArrayList;
import java.util.List;

public class ImplementStackUsingArray {
    private List<Integer> list;

    private ImplementStackUsingArray() {
        this.list = new ArrayList<>();
    }

    private void push(int x) {
        list.add(x);
    }

    private boolean pop() {
        if (list.isEmpty()) {
            return false;
        } else {
            list.remove(list.size() - 1);
            return true;
        }
    }

    private int top() {
        return list.get(list.size() - 1);
    }

    private boolean isEmpty() {
        return list.isEmpty();
    }
}
