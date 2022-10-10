package stepDefinitions;

import bank.Bank;
import bank.DemirBank;
import bank.OptimaBank;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {

    DemirBank ataiDemirAccount = new DemirBank(123456789111l, 111111111l);
    DemirBank nurazizDemirAccount = new DemirBank(111111111111l, 222222222l);

    OptimaBank adiletOptima = new OptimaBank(112233445566l, 324354657l);


    public StepDefinitions() throws Exception {
    }


    @Given("User is logged in to Demir account")
    public void user_is_logged_in_to_demir_account() {
        System.out.println("User is logged in.");
    }

    @When("User deposit ${int} to Atai")
    public void user_deposit_$_to_atai(Integer amount) {
        ataiDemirAccount.deposit(amount);
    }

    @Then("Atai should have ${int} in balance")
    public void atai_should_have_$_in_balance(Integer expectedBalance) {
        Double x = Double.valueOf(expectedBalance);
        Assertions.assertEquals(x, ataiDemirAccount.getBalance());
    }

    @When("User deposit ${int} to Nuraziz")
    public void user_deposit_$_to_nuraziz(Integer amount) {
        nurazizDemirAccount.deposit(amount);
    }

    @Then("Nuraziz should not have ${int} in balance")
    public void nuraziz_should_not_have_$_in_balance(Integer expectedBalance) {
        Double y = Double.valueOf(expectedBalance);
        Assertions.assertNotEquals(y, nurazizDemirAccount.getBalance());
    }

    @Given("User has {int} in the account")
    public void user_has_in_the_account(Integer balanceAmount) {
        adiletOptima.deposit(balanceAmount);
    }

    @When("User deposits {int} to John Doe")
    public void user_deposits_to_john_doe(Integer balanceAmount) {
        Bank.transferFunds(adiletOptima, ataiDemirAccount, balanceAmount);
    }

    @Then("User should have {int}")
    public void user_should_have(Integer balanceAmount) {
        Assertions.assertEquals(Double.valueOf(balanceAmount), adiletOptima.getBalance());
    }

    @Then("John Doe Should not have any deposits")
    public void john_doe_should_not_have_any_deposits() {
        System.out.println(adiletOptima.getBalance());
    }


}
