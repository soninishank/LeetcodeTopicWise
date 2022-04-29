package LLD.SOLID.ISP;

public class Paytm implements UPIPayments {
    @Override
    public void payMoney() {

    }

    @Override
    public void getScratchCard() {

    }

//    // Not there in paytm - we should not force our client to implement this method
//    // it violates the Interface segregation principle
//    @Override
//    public void getCashBackAsCreditBalance() {
//
//    }
}
