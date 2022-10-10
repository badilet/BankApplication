package bank;

public class DemirBank extends BankBase {

    private double balance = 200;

    public DemirBank(long accountNumber, long routingNumber) throws Exception {
        super(accountNumber, routingNumber);
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0 || amount > 20000) {
            System.out.println("Invalid amount, limit is 20000.");
        } else {
            balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount < 0 || amount > 5000) {
            System.out.println("Can not be withdrawn, limit is 5,000");
        } else {
            if (balance < amount) {
                System.out.println("Insufficient funds");
            } else {
                balance -= amount;
            }
        }
    }
}
