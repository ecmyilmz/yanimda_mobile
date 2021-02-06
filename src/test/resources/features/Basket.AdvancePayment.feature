@basket
Feature: Advance Payment Basket

  Scenario: 1 Verify the advance payment product has been added to the basket
    When User goes to eShop
    And User adds advance payment product to basket

  Scenario: 2 Verify the advance payment product has been deleted to the basket
    When User goes to eShop
    And User deletes product from basket