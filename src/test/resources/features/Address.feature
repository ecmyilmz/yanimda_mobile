Feature: Order Information Page

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     Then User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds the product to basket
     Then User goes to order information page
     And User enters order information
     And User enters the correct OTP and clicks continue button

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     Then User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds advance payment product to basket
     Then User goes to order information page
     And User enters order information
     And User enters the correct OTP and clicks continue button

  Scenario: 1 Verify that the product goes to the order information page properly
    Given User goes to eShop
     Then User goes into the details for eShopHome.SamsungGalaxyS20
     And User adds vanilla product to basket
     Then User goes to order information page
     And User enters order information
     And User enters the correct OTP and clicks continue button


