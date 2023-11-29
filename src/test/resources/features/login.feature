Feature: I want to login to the application

Scenario: I want to login to the application
Given open browser 
And I open login page
When I enter my username
And I enter my password 
And I should click submit
Then I should get confirmation message 

Scenario: I want to login to the application with invalid username and valid password
Given open browser 
And I open login page
When I enter invalid username
And I enter validpassword 
And I should click submit
Then I should get invalid username message

Scenario: I want to login to the application with valid username and invalid password
Given open browser 
And I open login page
When I enter valid username
And I enter invalid password 
And I should click submit
Then I should get invalid password message