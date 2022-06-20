package LLD.Multithreading.ThreadCreation;

public class AliceThread extends Thread {

    private BankAccount aliceAccount;
    private BankAccount bobAccount;

    public AliceThread(BankAccount aliceAccount, BankAccount bobAccount) {
        this.aliceAccount = aliceAccount;
        this.bobAccount = bobAccount;
    }

    @Override
    public void run() {
        System.out.println("Alice started job");
       for (int i = 0 ; i < 1000 ; i++){
           aliceAccount.withdraw(1);
           bobAccount.deposit(1);
       }
        System.out.println("Alice completed job");
    }
}
