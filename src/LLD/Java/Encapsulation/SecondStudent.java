package LLD.Java.Encapsulation;

public class SecondStudent {
    public static void main(String[] args) {
        Coat secondCoat = new Coat();
        calculateCoatPrice(secondCoat, 100);
    }

    public static void calculateCoatPrice(Coat coat, double price) {
        //if price is public variable,we can set its value like this
        coat.price = price * 0.5;
        System.out.println(coat.price);
    }
}
