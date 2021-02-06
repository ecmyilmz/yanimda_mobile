@basket
Feature: Advance Payment Basket

  Scenario: 1 Verify the advance payment product has been added to the basket
    When User goes to eShop
    Then User should see item.SamsungGalaxyS20 displayed
    And User goes into the details for item.SamsungGalaxyS20
    And User adds advance payment product to basket
    And User should see item.deleteIcon displayed

  Scenario: 2 Verify the advance payment product has been deleted to the basket
    When User goes to eShop
    And User deletes product from basket


