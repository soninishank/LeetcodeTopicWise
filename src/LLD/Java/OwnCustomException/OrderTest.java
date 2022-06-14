package LLD.Java.OwnCustomException;

public class OrderTest {
    public void getOrder(int orderId) throws OrderNotFoundException {
        if (orderId == 101) {
            throw new OrderNotFoundException("order is not available for id " + orderId);
        }
    }

    public static void main(String[] args) throws OrderNotFoundException {
        new OrderTest().getOrder(191);
    }
}
