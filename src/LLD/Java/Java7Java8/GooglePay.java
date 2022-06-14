package LLD.Java.Java7Java8;

public class GooglePay implements Payment {


    // It's necessary to override this method
    @Override
    public void doTransaction() {
        System.out.println("GPay transaction");
    }

    @Override
    public void addCoupon() {
        Payment.super.addCoupon(); // if you want to provide the same impl
    }
}
