@regression
Feature: Basket Page

  Scenario: 1 Verify the product has been added to the basket
  Given User goes to eShop
    Then User should see eShopHome.SamsungGalaxyS20 displayed
    And User goes into the details for eShopHome.SamsungGalaxyS20
    And User adds the product to basket
    And User should see BasketPage displayed

  Scenario: 2 Verify the product has been deleted to the basket
    Given User goes to eShop
     And User deletes product from basket
     And User should not see item.deleteIcon

  Scenario: 3 Verify the advance payment product has been added to the basket
    Given User goes to eShop
     When User should see eShopHome.SamsungGalaxyS20 displayed
     And User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds advance payment product to basket
     Then User should see BasketPage displayed

  Scenario: 4 Verify the advance payment product has been deleted to the basket
    Given User goes to eShop
     When User deletes product from basket
     Then User should not see item.deleteIcon

  Scenario: 5 Verify the vanilla product has been added to the basket
    Given User goes to eShop
     When User should see eShopHome.SamsungGalaxyS20 displayed
     And User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds vanilla product to basket
     Then User should see BasketPage displayed

  Scenario: 6 Verify the second vanilla product has been added to the basket
    Given User goes to eShop
     When User goes into the details for eShopHome.SamsungGalaxyS20
     Then User adds vanilla product to basket

  Scenario: 7 Verify the vanilla product has been deleted to the basket
   Given User goes to eShop
    When User deletes vanilla product from basket
    Then User should not see eShopHome.SamsungGalaxyS20

