Feature: SortAlphabeticallyInAscendingOrder

Scenario: Verify user is able to sort the values based on alphabets in ascending order

Given Browser is launched and url is navigated
And User is logged in with "standard_user" and "secret_sauce"
And Homepage is displayed
And User selects "Name (A to Z)" drop down to sort the products in ascending order
Then Products should be sorted in ascending order of alphabets