package LLD.Java.ExceptionHierarchy;

public class Parent {
    public void m1() throws Exception {
        System.out.println("Parent m1()");
    }

    public void childThrowingException() throws Exception {
        System.out.println("parent need to handle the exception if child is throwing it");
    }

    public static void m2() {
        System.out.println("Parent static m1()");
    }
}
