Feature: login functionality

Background:
Given user should be on login page

Scenario: valid login
When user enters valid credentials and click on login button
Then user should be navigated to home page
And user can validate logout link
And close browser

Scenario Outline: valid login with multiple credentials
When user enters valid userid as "<userid>" and valid password as "<password>" click on login button
Then user should be navigated to home page
And user can validate logout link
And close browser
Examples:
|userid | password|
|admin | admin|
|admin | admin|
|admin | admin|



Scenario: Invalid login
When user enters Invalid credentials and click on login button
Then user should be navigated to login page
And user can validate error message
And close browser
