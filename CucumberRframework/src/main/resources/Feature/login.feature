Feature: login functionality
Background:
Given user should be on login page
@maya
Scenario: valid login

When user enters valid username
And user enter valid password
And user click on Login button
Then user should be navigated to home page
And user can validate logout link
And close browser

@gauri
Scenario: Invalid login
When user enter invalid Credential 
Then user should navigate to login page
And user can see error message 
And close browser
 
@swappy
Scenario Outline: Invalid login with multiple test data
When user enters invalid username as "<userid>"
And user enter invalid password as "<password>"
And user click on Login button
Then user should navigate to login page
And user can see error message
And close browser
Examples:
|userid|password|
|admin1|pass1|
|admin2|pass2|
|admin3|pass3|


@shesha
Scenario: Create Lead
Given user should be on home page
When user click on new lead link and fill valid data and click on save button.
Then Lead should be created successfully
|name|company|
|gauri|google|
|swappy|edac|
|swapnil|comou|
|shesha|birlasoft|





