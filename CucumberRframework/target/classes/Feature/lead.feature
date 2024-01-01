@mylead
Feature: lead 
Background: 
Given user should be on home page

@lead
Scenario: valid lead cration vtiget_TC01
When user click on new lead tab leadinfo form should open 
And user enter lastname and company  
And Click on save button
Then user should navigate to leads page and lead should created successfully 

@deletelead
Scenario: delete lead vtiget_TC02
When user click on leads tab user can see leads list
When user click on any lead element 
And click on delete button
Then user click on ok
Then lead element should delete from leads list.

@leadactivity
Scenario: assign activity to lead vtiger_TC03
When lead should be created and user should navigate to leads page 
When user click on new task,user should navigate to activities page
And enter start date and due date
And select lead from dropdownlist
And select status from dropdownlist
And check the notification from checkbox
And select contact name
And click on save button
Then user should get error message
Then user should accept that message click on ok
Then enter subject
Then click on save 
Then new created activities should present on leads page. 

 
