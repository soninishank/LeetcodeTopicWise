package LLD.Java.FunctionalInterface;

public class CalculatorImpl {

    public static void main(String[] args) {
        Calculator calculator = () -> System.out.println("switch on");// now you don't need to implement
        calculator.switchOn();

        DoAddition addition = (input) -> System.out.println("the addition is " + input); // no need of providing the data type
        addition.sum(10);
    }
}
