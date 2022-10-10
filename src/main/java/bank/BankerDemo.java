package bank;

public class BankerDemo {
    public static void main(String[] args) throws Exception {

        DemirBank ataiDemirAccount = new DemirBank(123456789111l, 111111111l);
        System.out.println(ataiDemirAccount.getBalance());
        ataiDemirAccount.deposit(1000);
        System.out.println("Atai's balance: " + ataiDemirAccount.getBalance());

        DemirBank nurazizDemirAccount = new DemirBank(111111111111l, 222222222l);
        System.out.println("Nuraziz's balance: " + nurazizDemirAccount.getBalance());
        nurazizDemirAccount.deposit(600);
        System.out.println("Nuraziz's balance: " + nurazizDemirAccount.getBalance());

        Bank.transferFunds(nurazizDemirAccount, ataiDemirAccount, 500);
        System.out.println("Atai's balance: " + ataiDemirAccount.getBalance());
        System.out.println("Nuraziz's balance: " + nurazizDemirAccount.getBalance());

        OptimaBank adiletOptima = new OptimaBank(112233445566l, 324354657l);
        System.out.println("Adilet's balance: " + adiletOptima.getBalance());

        Bank.transferFunds(ataiDemirAccount, adiletOptima, 300);
        System.out.println("Atai's balance: " + ataiDemirAccount.getBalance());
        System.out.println("Adilet's balance: " + adiletOptima.getBalance());


    }
}
