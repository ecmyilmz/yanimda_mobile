Feature: Basket

  Scenario: 1 Verify the product has been added to the basket
    Given User goes to eShop
    And User adds product to basket

  Scenario: 2 Verify the product has been deleted to the basket
    Given User goes to eShop
    And User deletes product from basket
