Feature: ValidLoginCredentials

Scenario Outline: Verify user is able to login using valid credentials

Given Browser is launched and url is navigated
And User enters valid username and password
|<Username>| <Password>|
And Clicks on login button
Then Homepage is displayed
And User is logged out

Examples:
|Username 		 				  | Password   |
|standard_user  				|secret_sauce|
|problem_user						|secret_sauce|
|performance_glitch_user|secret_sauce|
|error_user   					|secret_sauce|
|visual_user						|secret_sauce|
							