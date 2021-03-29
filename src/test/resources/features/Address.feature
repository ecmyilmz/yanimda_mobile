Feature: Order Information Page

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     When User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds the product to basket
     And User goes to order information page
     And User enters order information
     Then User enters the correct OTP and clicks continue button

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     When User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds advance payment product to basket
     And User goes to order information page
     And User enters order information
     Then User enters the correct OTP and clicks continue button

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     When User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds vanilla product to basket
     And User goes to order information page
     And User enters order information
     Then User enters the correct OTP and clicks continue button


