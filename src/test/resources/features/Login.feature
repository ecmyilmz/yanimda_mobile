Feature: Login

  Scenario: 1 Verify this correct user when the application is started
    Given User tap on VfLoginButton
    #And User tap on login.loginButton
    When User login as "data.msisdn" and "data.password" and "data.otp"
    And User should see home.homePage displayed




    



