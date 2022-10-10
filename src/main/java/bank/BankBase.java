package bank;

public abstract class BankBase implements Bank {

    private long accountNumber;
    private long routingNumber;

    public BankBase(long accountNumber, long routingNumber) throws Exception {
        if (Long.toString(accountNumber).length() != 12) {
            throw new Exception("Account number must be 12 digits.");
        } else if (Long.toString(routingNumber).length() != 9) {
            throw new Exception("Routing number must be 9 digits.");
        } else {
            this.accountNumber = accountNumber;
            this.routingNumber = routingNumber;
        }
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(long routingNumber) {
        this.routingNumber = routingNumber;
    }
}
