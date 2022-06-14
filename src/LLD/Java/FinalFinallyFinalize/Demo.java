package LLD.Java.FinalFinallyFinalize;

public class Demo {
    private final int a = 10;

    public void m1() {
        //a=20;//can't reassign - it will throw CTE
        try {
            System.out.println("try block");
        } finally {
            System.out.println("finally block");
            //clean those stream - JDBC Connection
        }
    }

    // present in java.lang.object class
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize method called...");
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.m1();
        demo = null; // if you comment this than finalize() will not get invoked
        System.gc(); // finalize method called...
    }
}
