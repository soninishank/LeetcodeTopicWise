package LLD.SOLID.DIP;

public class DebitCard implements BankCard {
    @Override
    public void doTransaction(long amount) {
        System.out.println("payment using Debit card");
    }
}
