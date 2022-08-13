package Coding.Recursion;

public class OneToN {

    void print1ToN(int n) {
        if (n == 0) {
            return;
        }
        print1ToN(n - 1);
        System.out.println(n);
        return;
    }

    public static void main(String[] args) {
        //  new OneToN().print1ToN(10);
        //  new OneToN().printNTo1(10);
        new OneToN().sortAnArray(new int[]{5, 1, 0, 2});
    }

    private void sortAnArray(int[] ints) {

    }

    private void printNTo1(int n) {
        if (n == 0) {
            return;
        }
        System.out.println(n);
        printNTo1(n - 1);
    }
}
