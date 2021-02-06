Feature: Payment

  Scenario: 1 Verify the product has been bought properly
    Given User goes to eShop
    Then User should see item.SamsungGalaxyS20 displayed
    And User goes into the details for item.SamsungGalaxyS20
    And User adds the product to basket
    And User should see item.deleteIcon displayed
    And User goes to order information page
    And User enters order information

