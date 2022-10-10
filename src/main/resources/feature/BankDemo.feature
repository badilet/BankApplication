@Smoke
Feature: Bank fund transfer functionality

  Scenario: Deposit within allowed range
    #Given steps are used for precondition
    Given User is logged in to Demir account
    #Then action
    When User deposit $1000 to Atai
    #Then validation
    Then Atai should have $1200 in balance


  Scenario: Deposit above limit
    Given User is logged in to Demir account
    When User deposit $50000 to Nuraziz
    Then Nuraziz should not have $50000 in balance


  Scenario: Deposit negative value
    Given User is logged in to Demir account
    And   User has 300 in the account
    When  User deposits -10 to John Doe
    Then  User should have 300
    And   John Doe Should not have any deposits


  Scenario: Withdraw within the limit
    Given User account with accountNumer 234523453245 and routing number 123456789 is opened
    And User deposits $1000.00
    When User withdraws $1000.00
    Then User should have $0.0 in account


  Scenario: Withdraw over the limit
    Given User account with accountNumer 234523453245 and routing number 123456789 is opened
    And User deposits $1000.00
    When User withdraws $1500.00
    Then User should have $1000.0 in account


  Scenario: Withdraw with insufficient funds from initial balance
    Given User account with accountNumer 234523453245 and routing number 123456789 is opened
    When User withdraws $10.00
    Then User should have $0.0 in account


  Scenario: Withdraw from 0 balance
    Given User account with accountNumer 234523453245 and routing number 123456789 is opened
    And User deposits $-1000.00
    When User withdraws $10.00
    Then User should have $0.0 in account