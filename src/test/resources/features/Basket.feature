Feature: Basket

  Scenario: 1 Verify the product has been added to the basket
    Given User goes to eShop
    Then User should see item.SamsungGalaxyS20 displayed
     And User goes into the details for iPhone
     And User adds the product to basket
     And User should see "x" displayed

#  Scenario: 2 Verify the product has been deleted to the basket
#    Given User goes to eShop
#    And User deletes product from basket User should see "item.SamsungGalaxyS20" displayed
