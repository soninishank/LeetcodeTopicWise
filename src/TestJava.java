import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestJava {

    private void m1() {
        List<Integer> list = Arrays.asList(1,2,3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(2)) {
                list.remove(next);
            }
        }
        System.out.println(list);
    }

    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        testJava.m1();
    }
}
