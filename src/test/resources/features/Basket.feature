@regression
Feature: Basket Page

  Scenario: 1 Verify the product has been added to the basket
  Given User goes to eShop
    Then User should see item.SamsungGalaxyS20 displayed
    And User goes into the details for item.SamsungGalaxyS20
    And User adds the product to basket
    And User should see BasketPage displayed

  Scenario: 2 Verify the product has been deleted to the basket
    Given User goes to eShop
    And User deletes product from basket
    And User should not see item.deleteIcon
