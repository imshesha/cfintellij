Feature: Login Functinality
Scenario: valid login
Given user is on login page
When user Enter valid username
And user enter valid password
And click on submit button
Then user should navigate to Home page
And user can see logout link

