Feature: LoginLogout

Scenario: Verify user is able login and logout

Given Browser is launched and url is navigated
When User enters valid "standard_user" and "secret_sauce"
And Clicks on login button
Then  Home page should be displayed
And User clicks on menu button and clicks on logout
And User should be logged out
