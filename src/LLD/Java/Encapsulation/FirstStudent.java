package LLD.Java.Encapsulation;

public class FirstStudent {
    public static void main(String[] args) {
        Coat firstCoat = new Coat();
        calculateCoatPrice(firstCoat, 100);
    }

    public static void calculateCoatPrice(Coat coat, double price) {
        //if price is public variable,we can set its value like this
        coat.price = price * 0.7;
        System.out.println(coat.price);
    }
}
