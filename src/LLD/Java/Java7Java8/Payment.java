package LLD.Java.Java7Java8;

public interface Payment {
    void doTransaction();

    /**
     * ignore if you don't want to add any addCoupon features in any of your impl
     * directly access from super class , if you want to use same impl
     *
     * @Override addCoupon method if you want to provide different impl
     **/

    // The purpose is not to force impl class, to override in Impl class
    default void addCoupon() {
        System.out.println("add 5 RS cashback"); // in default method you can write the method body
    }

    static void generateTransactionReport() {
        System.out.println("generate each transaction report");
    }
}
