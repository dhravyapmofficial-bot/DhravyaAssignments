Feature: Create Salesforce Account

  Scenario: Create a new account in Salesforce
    Given User launches Salesforce login page
    When User logs in with valid credentials
    And User clicks on App Launcher toggle
    And User navigates to Sales app
    And User clicks on Accounts tab
    And User clicks on New account button
    And User enters account name as "Dhravya"
    And User selects ownership as Public
    And User saves the account
    Then Account should be created successfully

