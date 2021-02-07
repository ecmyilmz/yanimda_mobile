Feature: Advance Payment Order Information Page

  Scenario: 1 Verify that the product goes to the order information page properly
    When User goes to eShop
    And User goes into the details for item.SamsungGalaxyS20
    And User adds advance payment product to basket
    And User goes to order information page
    And User should see orderInformation displayed