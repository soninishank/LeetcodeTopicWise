package LLD.Java.FunctionalInterface;

public interface FunctionalInterface {
    void m1(); // abstract functional interface - have only one single abstract method

    default void m2() {
        System.out.println("Default method-2");
    }

    default void m3() {
        System.out.println("Default method-3");
    }
}
