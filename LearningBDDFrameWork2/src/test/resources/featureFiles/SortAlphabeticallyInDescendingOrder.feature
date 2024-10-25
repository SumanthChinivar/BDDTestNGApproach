Feature: SortAlphabeticallyInAscendingOrder

Scenario: Verify user is able to sort the values based on alphabets in ascending order

Given Browser is launched and url is navigated
And User is logged in with "standard_user" and "secret_sauce"
And Homepage is displayed
And User selects "Name (Z to A)" drop down to sort the products in descending order
Then Products should be sorted in descending order of alphabets