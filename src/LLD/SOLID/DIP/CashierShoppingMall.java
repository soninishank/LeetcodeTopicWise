package LLD.SOLID.DIP;

public class CashierShoppingMall {

    private final BankCard bankCard;

    public CashierShoppingMall(BankCard bankCard) {
        this.bankCard = bankCard;
    }

    void doPurchaseSomething(long amount) {
        bankCard.doTransaction(amount);
    }

    public static void main(String[] args) {
        BankCard bankCard1 = new DebitCard();
        CashierShoppingMall shoppingMall = new CashierShoppingMall(bankCard1);
        shoppingMall.doPurchaseSomething(1000);

        BankCard bankCard = new CreditCard();
        CashierShoppingMall shoppingMall1 = new CashierShoppingMall(bankCard);
        shoppingMall1.doPurchaseSomething(5000);
    }
}
