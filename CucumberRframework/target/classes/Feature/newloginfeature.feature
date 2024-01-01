@shivanya
Feature: all tc from hybrid framework

Scenario: Verify login TC_01 
Given user should be on login page
When user perform valid login
Then user should be navigated to home page 

Scenario: verifyInValidlogin_TC02
Given user should be on login page
When user perform Invalid login
Then user should validate error message

Scenario: verifyLogoonLoginScreen_TC03
Given user should be on login page
Then user should validate logo

