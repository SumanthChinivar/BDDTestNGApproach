Feature: Add to cart

Scenario: Verify user is able to add a product to the cart

Given Browser is launched and url is navigated
And User is logged in with "standard_user" and "secret_sauce"
When User clicks on "Sauce Labs Backpack" add to cart button
Then "Sauce Labs Backpack" product is added to cart
