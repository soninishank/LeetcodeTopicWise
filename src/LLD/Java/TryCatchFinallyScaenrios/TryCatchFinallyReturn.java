package LLD.Java.TryCatchFinallyScaenrios;

public class TryCatchFinallyReturn {
    // because finally is always executed if there are no exceptions in try block
    public static int m1WithoutExceptionWithFinally() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            // we can break this rule, just add System.exit(0)
            // your code is terminated
            return 3;
        }
    }

    public static int m1WithoutExceptionWithoutFinally() {
        try {
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    public static int m1WithExceptionWithoutFinally() {
        try {
            System.out.println(10 / 0);
            return 1;
        } catch (Exception e) {
            return 2;
        }
    }

    public static void main(String[] args) {
        System.out.println("No Exception  - with finally block - finally block return" + m1WithoutExceptionWithFinally());
        System.out.println("No Exception - without finally block - try block return " + m1WithoutExceptionWithoutFinally());
    }
}
