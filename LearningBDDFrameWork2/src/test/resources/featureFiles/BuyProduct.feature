Feature: BuyProduct

Scenario: Verify user is able to buy a product

Given Browser is launched and url is navigated
And User is logged in with "standard_user" and "secret_sauce"
When User clicks on "Sauce Labs Bike Light" add to cart button
Then "Sauce Labs Bike Light" Add to cart button should be turned into remove button
And Navigate to cart page
And "Sauce Labs Bike Light" should be added to the cart
And User clicks on ckeck out button
And User enters "Sumanth","Chinivar" and "570085"
And Clicks on continue
And "Sauce Labs Bike Light" should be displayed in check out page
And Display payment id, shipping information and price total
And Click on finish
And Verify "Thank you for your order!" has been displayed
And Click on back home button