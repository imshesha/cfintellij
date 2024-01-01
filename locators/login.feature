Feature: login Functinality
Scenario: valid Login
Given user is on login page
When user enter valid username
And user enter valid password
And Click on login button
Then user should navigate to Home page
And user can see logout link