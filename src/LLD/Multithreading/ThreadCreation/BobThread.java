package LLD.Multithreading.ThreadCreation;

public class BobThread extends Thread {
    private final BankAccount aliceAccount;
    private final BankAccount bobAccount;

    public BobThread(BankAccount aliceAccount, BankAccount bobAccount) {
        this.aliceAccount = aliceAccount;
        this.bobAccount = bobAccount;
    }

    @Override
    public void run() {
        System.out.println("bob started job");
        for (int i = 0; i < 1000; i++) {
            bobAccount.withdraw(1);
            aliceAccount.deposit(1);
        }
        System.out.println("bob completed job");
    }
}
