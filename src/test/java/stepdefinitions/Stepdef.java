package stepdefinitions;

import behavior.Behave;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.Hooks;


import java.io.IOException;
import java.util.*;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class Stepdef extends Behave {
    private Hooks hooks;
    private Properties selectors;

    static String productAmount = "";

    public Stepdef(Properties selectors, Hooks hooks) {
        this.hooks = hooks;
        this.selectors = selectors;

        try {
            selectors.load(Stepdef.class.getResourceAsStream("/selectors/selector.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyValue(String id) {
        Optional<String> opt = Optional.ofNullable(selectors.getProperty(id));
        if (opt.isPresent())
            return opt.get();
        else
            fail("Error in selectors.properties or Gherkin file ;" + id + " could not be found in selectors.properties!");
        return null;
    }


    @When("^([^\"]) taps on ([^\"]*)$")
    public void TapsOn(String arg1, String arg2) throws Exception {
        setDriver(arg1);
        tap(getPropertyValue(arg2));
    }

    @When("^([^\"]) control amount ([^\"])$")
    public void controlAmount(String arg1, String arg2) throws Exception {
        setDriver(arg1);
        if ((!driver.findElements(getBy(getPropertyValue(arg2))).isEmpty())) {
            assertTrue(driver.findElement(getBy(getPropertyValue(arg2))).getText().equals(productAmount));
        }
    }

    @When("^([^\"]) logins as \"([^\"])\" and \"([^\"])\" and \"([^\"]*)\"$")
    public void userLoginsAsAnd(String arg1, String username, String password, String otp) throws Exception {
        setDriver(arg1);
        type(getPropertyValue("login.msisdnInput"), username);
        type(getPropertyValue("login.passwordInput"), password);
        tap(getPropertyValue("login.sendCodeButton"));
        type(getPropertyValue("login.otpInput"), otp);
        tap(getPropertyValue("login.loginButton"));
    }

    @Given("^([^\"]) tutorial control ([^\"])$")
    public void tutorialControl(String arg1, String arg2) {
        setDriver(arg1);
        if ((!driver.findElements(getBy(getPropertyValue(arg2))).isEmpty())) {
            tap(getPropertyValue(arg2));
        }
    }


    @Then("^([^\"]*) should see ([^\"]*) displayed$")
    public void iShouldSeeDisplayed(String arg1, String arg2) {
        setDriver(arg1);
        waitForElement(getPropertyValue(arg2));
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
        } else {
            System.out.println("User login değil");
            tap(getPropertyValue("VfLoginButton"));
            sleepms(10000);
            setUserAut2();

            if(getHasRememberedAccount()==true){
                System.out.println(("kayıtlı hesap var sadece click yaptırt"));
            }else{
                System.out.println("kayıtlı hesap yok user bılgılerını gırın");
                type(getPropertyValue("login.msisdnInput"), "data.msisdn");
                type(getPropertyValue("login.passwordInput"), "data.password");
                tap(getPropertyValue("login.sendCodeButton"));
                type(getPropertyValue("login.otpInput"), "data.otp");
            }
            tap(getPropertyValue("login.loginButton"));
        }
        tap(getPropertyValue("home.advantagesButton"));
        tap(getPropertyValue("home.eshopButton"));
    }

    @And("^([^\"]*) adds the product to basket$")
    public void addsTheProductToBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("item.SamsungGalaxyS20"));
        tap(getPropertyValue("detail.addBasketButton"));

    }

    @And("^([^\"]*) deletes product from basket$")
    public void deletesProductFromBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("eshop.basketButton"));
        tap(getPropertyValue("item.deleteIcon"));
        tap(getPropertyValue("item.deleteConfirmButton"));
    }

    @And("^([^\"]*) adds advance payment product to basket$")
    public void addsAdvancePaymentProductToBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("item.SamsungGalaxyS20"));
        tap(getPropertyValue("detail.advancePaymentButton"));
        tap(getPropertyValue("detail.addBasketButton"));
    }

    @And("^([^\"]*) adds vanilla product to basket$")
    public void addsVanillaProductToBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("detail.vanillaButton"));
        tap(getPropertyValue("detail.addBasketButton"));
    }

    @And("^([^\"]*) deletes vanilla product from basket$")
    public void deletesVanillaProductFromBasket(String arg1) {
        setDriver(arg1);
        tap(getPropertyValue("eshop.basketButton"));
        tap(getPropertyValue("item.vanillaDeleteConfirmIcon"));
        tap(getPropertyValue("item.deleteConfirmButton"));
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
        tap(getPropertyValue("item.countyButton"));
        tap(getPropertyValue("item.countySelect"));
        tap(getPropertyValue("item.neighborhoodButton"));
        tap(getPropertyValue("item.neighborhoodSelect"));
        tap(getPropertyValue("item.streetButton"));
        tap(getPropertyValue("item.streetSelect"));
        type(getPropertyValue("item.apartInput"), "data.apart");
        type(getPropertyValue("item.doorNoInput"), "data.apart");
    }


    @And("^([^\"]*) goes into the details for ([^\"]*)$")
    public void userGoesIntoTheDetailsForIPhone(String arg1, String arg2) {
        setDriver(arg1);
        tap(getPropertyValue("item.SamsungGalaxyS20"));
    }
}

