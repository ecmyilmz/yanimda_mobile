package stepdefinitions;



import core.User;
import io.cucumber.java.en.Given;
import pages.Mobile.LoginPage;


public class StepDefinitions {


   /* @When("^([^\"]*) taps on ([^\"]*)$")
    public void TapsOn(String arg1, String arg2) throws Exception {
        setDriver(arg1);
        tap(getPropertyValue(arg2));
    }

    @When("^([^\"]*) control amount ([^\"]*)$")
    public void controlAmount(String arg1, String arg2) throws Exception {
        setDriver(arg1);
        if ((!driver.findElements(getBy(getPropertyValue(arg2))).isEmpty())) {
            assertTrue(driver.findElement(getBy(getPropertyValue(arg2))).getText().equals(productAmount));
        }
    }
*/
    @Given("^([^\"]*) goes to login page$")
    public void goesToLoginPage(User user) throws Exception {
      user.getDevice().getYanimda().vfLogin(user);



    }


    /*@When("^([^\"]*) logins* as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void loginsAsAndAnd(String arg1, String phoneNumber, String password, String otp) throws Exception {
        setDriver(arg1);
        sleepms(10000);
        type(getPropertyValue("login.msisdnInput"), phoneNumber);
        type(getPropertyValue("login.passwordInput"), password);
        tap(getPropertyValue("login.sendCodeButton"));
        tap(getPropertyValue("login.otpButton"));
        sleepms(10000);
        typeOtp(getPropertyValue("login.otpInput1"), otp);
        typeOtp(getPropertyValue("login.otpInput2"), otp);
        typeOtp(getPropertyValue("login.otpInput3"), otp);
        typeOtp(getPropertyValue("login.otpInput4"), otp);
        tap(getPropertyValue("login.loginButton"));
        sleepms(10000);
    }

    @When("^([^\"]*) logs in with the wrong password")
    public void logsInWithTheWrongPassword(String arg1) throws Exception{
        setDriver(arg1);
        sleepms(5000);
        type(getPropertyValue("login.msisdnInput"),"5463003098");
        type(getPropertyValue("login.passwordInput"), "00000000");
        tap(getPropertyValue("login.sendCodeButton"));
        sleepms(5000);
    }

    @When("^([^\"]*) logs in with the wrong OTP")
    public void logsInWithTheWrongOTP(String arg1) throws Exception {
        setDriver(arg1);
        sleepms(10000);
        type(getPropertyValue("login.msisdnInput"), "5463003098");
        type(getPropertyValue("login.passwordInput"), "11111111");
        tap(getPropertyValue("login.sendCodeButton"));
        tap(getPropertyValue("login.otpButton"));
        sleepms(5000);
        typeOtp(getPropertyValue("login.otpInput1"), "0");
        typeOtp(getPropertyValue("login.otpInput2"), "0");
        typeOtp(getPropertyValue("login.otpInput3"), "0");
        typeOtp(getPropertyValue("login.otpInput4"),"0");
        tap(getPropertyValue("login.loginButton"));
        sleepms(10000);
    }

    @Given("^([^\"]*) tutorial control ([^\"]*)$")
    public void tutorialControl(String arg1, String arg2) {
        setDriver(arg1);
        sleepms(10000);
        if ((!driver.findElements(getBy(getPropertyValue(arg2))).isEmpty())) {
            tap(getPropertyValue(arg2));
        }
    }


    @Then("^([^\"]*) should see ([^\"]*) displayed$")
    public void iShouldSeeDisplayed(String arg1, String arg2) {
        setDriver(arg1);
        sleepms(10000);
        waitForElement(getPropertyValue(arg2));
    }

    @Then("^([^\"]*) should not see ([^\"]*)$")
    public void iShouldNotSee(String arg1, String arg2) {
        setDriver(arg1);
        sleepms(10000);
        assertTrue(driver.findElements(getBy(arg2)).isEmpty());
    }


    @And("^([^\"]*) press back$")
    public void pressBack(String arg1) {
        setDriver(arg1);
        driver.navigate().back();
    }

    @When("^([^\"]*) goes to eShop$")
    public void goesToEShop(String arg1) throws Exception {
        setDriver(arg1);
        sleepms(10000);
        setUserAut();

        if(getIsUserLogin()==true){
            System.out.println("User login");
            sleepms(10000);
        } else {
            System.out.println("User login değil");
            tap(getPropertyValue("VfLoginButton"));
            sleepms(10000);
            setUserAut2();

            if(getHasRememberedAccount()==true){
                sleepms(10000);
                System.out.println(("kayıtlı hesap var sadece click yaptırt"));
            }else{
                sleepms(10000);
                System.out.println("kayıtlı hesap yok user bılgılerını gırın");
                type(getPropertyValue("login.msisdnInput"), "data.msisdn");
                type(getPropertyValue("login.passwordInput"), "data.password");
                tap(getPropertyValue("login.sendCodeButton"));
                type(getPropertyValue("login.otpInput"), "data.otp");
            }
            sleepms(10000);
            tap(getPropertyValue("login.loginButton"));
        }
        sleepms(10000);
        tap(getPropertyValue("home.advantagesButton"));
        sleepms(10000);
        tap(getPropertyValue("home.eshopButton"));
        sleepms(10000);
    }

    @And("^([^\"]*) adds the product to basket$")
    public void addsTheProductToBasket(String arg1) {
        setDriver(arg1);
        sleepms(10000);
        tap(getPropertyValue("detail.addBasketButton"));

    }

    @And("^([^\"]*) adds advance payment product to basket$")
    public void addsAdvancePaymentProductToBasket(String arg1) {
        setDriver(arg1);
        sleepms(10000);
        tap(getPropertyValue("detail.advancePaymentButton"));
        sleepms(10000);
        tap(getPropertyValue("detail.addBasketButton"));
    }

    @And("^([^\"]*) adds vanilla product to basket$")
    public void addsVanillaProductToBasket(String arg1) {
        setDriver(arg1);
        sleepms(10000);
        tap(getPropertyValue("detail.vanillaButton"));
        sleepms(10000);
        tap(getPropertyValue("detail.addBasketButton"));
    }

    @And("^([^\"]*) deletes product from basket$")
    public void deletesProductFromBasket(String arg1) {
        setDriver(arg1);
        sleepms(10000);
        tap(getPropertyValue("eshop.basketButton"));
        sleepms(5000);
        int size = driver.findElements(By.id("imgIconDeleteItem")).size();
        for (int i = 0; i < size; i++){
            sleepms(5000);
        tap(getPropertyValue("item.deleteIcon"));
        tap(getPropertyValue("item.deleteConfirmButton"));
        sleepms(5000);
        }
    }

    @And("^([^\"]*) deletes vanilla product from basket$")
    public void deletesVanillaProductFromBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("eshop.basketButton"));
        sleepms(5000);
        int size = driver.findElements(By.id("item.vanillaDeleteConfirmIcon")).size();
        for (int i = 0; i < size; i++) {
            sleepms(5000);
            tap(getPropertyValue("item.vanillaDeleteConfirmIcon"));
            tap(getPropertyValue("item.deleteConfirmButton"));
            sleepms(5000);
        }
    }

    @And("^([^\"]*) goes to order information page$")
    public void goesToOrderInformationPage(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("item.buyButton"));
    }

    @And("^([^\"]*) enters order information$")
    public void entersOrderInformation(String arg1) throws Exception {
        setDriver(arg1);
        tap(getPropertyValue("item.provinceButton"));
        tap(getPropertyValue("item.provinceSelect"));
        sleepms(5000);
        tap(getPropertyValue("item.countyButton"));
        tap(getPropertyValue("item.countySelect"));
        tap(getPropertyValue("item.neighborhoodButton"));
        tap(getPropertyValue("item.neighborhoodSelect"));
        tap(getPropertyValue("item.streetButton"));
        tap(getPropertyValue("item.streetSelect"));
        type(getPropertyValue("item.apartInput"), "data.apart");
        type(getPropertyValue("item.doorNoInput"), "data.apart");
        androidScrollToAnElementByText("T.C. Kimlik Numarası");
        type(getPropertyValue("T.C. Kimlik Numarası"), "data.password");
        androidScrollToAnElementByText("item.checkBox");
        tap(getPropertyValue("item.checkBox"));
        tap(getPropertyValue("item.confirmButton"));
    }


    @And("^([^\"]*) goes into the details for ([^\"]*)$")
    public void goesIntoTheDetailsForIPhone(String arg1, String arg2) {
        setDriver(arg1);
        sleepms(10000);
        tap(getPropertyValue("item.SamsungGalaxyS20"));
        sleepms(10000);
    }
*/

}

