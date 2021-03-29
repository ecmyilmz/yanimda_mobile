Feature: Payment

  Scenario: 1 Verify the product has been bought properly
    Given User goes to eShop
    When User goes into the details for eShopHome.SamsungGalaxyS20
    And User adds the product to basket
    And User goes to order information page
    And User enters order information
    Then User enters the correct OTP and clicks continue button


