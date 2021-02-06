@basket
Feature: Vanilla Basket

  Scenario: 1 Verify the vanilla product has been added to the basket
    When User goes to eShop
    Then User should see item.SamsungGalaxyS20 displayed
    And User goes into the details for item.SamsungGalaxyS20
    And User adds vanilla product to basket
    And User should see item.deleteIcon displayed

  Scenario: 2 Verify the second vanilla product has been added to the basket
    When User goes to eShop
     And User adds vanilla product to basket

  Scenario: 3 Verify the vanilla product has been deleted to the basket
    When User goes to eShop
    And User deletes vanilla product from basket




