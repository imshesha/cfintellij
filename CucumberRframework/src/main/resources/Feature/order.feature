Feature: sales order
Background:
Given user should be on Home page

@order
Scenario: Create valid new purchase order TC05
When user click on submenu
And user click on new sales order
When user enter subject and account nameaddress order information
And user enter address order information
And user enter product information
And click on save button
Then user should navigate to orders page and order should successfully created

