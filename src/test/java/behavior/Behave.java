package behavior;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.User;

import java.util.HashMap;

public class Behave {
    public WebDriver driver;
    private final int TAP_RETRY_COUNT = 4;
    private final int ELEMENT_LOAD_TIMEOUT = 30;
    public boolean isUserLogin;
    public boolean HasRememberedAccount;

    public void setDriver(String user) {
        driver = User.getUsers()
                .get(user)
                .getDevice()
                .getDriver();
    }


    public boolean getIsUserLogin() {
        return isUserLogin;
    }
    public void setIsUserLogin(boolean value){
        this.isUserLogin = value;
    }

    public boolean getHasRememberedAccount() {
        return HasRememberedAccount;
    }

    public void setHasRememberedAccount(boolean value){
        this.HasRememberedAccount = value;
    }

    public static void sleepms(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private WebElement getElement(String sel) {
        waitForElement(sel);
        return driver.findElement(getBy(sel));
    }

    public void tap(String sel) {
        int i = TAP_RETRY_COUNT;
        do {
            try {
                getElement(sel).click();
                break;
            } catch (Exception e) {
                sleepms(1000);
                i--;
                if (i == 0) {
                    throw e;
                }
            }
        } while (i > 0);
    }

    public void waitForElement(String id) {

        try {
            WebDriverWait waitElement = new WebDriverWait(driver, ELEMENT_LOAD_TIMEOUT);
            waitElement
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotVisibleException.class)
                   .until(ExpectedConditions
                     .visibilityOfElementLocated(getBy(id)));

            WebDriverWait waitElement2 = new WebDriverWait(driver, ELEMENT_LOAD_TIMEOUT);
            waitElement2
                    .ignoring(NoSuchElementException.class)
                    .ignoring(ElementNotVisibleException.class)
                    .until(ExpectedConditions
                    .elementToBeClickable(getBy(id)));
        } catch (TimeoutException e) {
            Assert.fail(e.getMessage());

        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }

    public boolean isElementExist(String id) {
        if(driver.findElements(getBy(id)).size() > 0)
        {
            return true;
        } else {
            return false;
        }
    }

    public void type(String sel, String keys) throws Exception {
        waitForElement(sel);
        WebElement el = getElement(sel);
        tap(sel);
        el.clear();
        el.sendKeys(keys);
    }

    public By getBy(String tag) {
        if (tag.substring(0, 1).equals("("))
            return By.xpath(tag);
        if (tag.substring(0, 1).equals("/"))
            return By.xpath(tag);
        else return By.id(tag);
    }

    public void setUserAut() {
        if(isElementExist("vFCardBTN")) {
            setIsUserLogin(false);
        } else {
            setIsUserLogin(true);
        }
    }
    public void setUserAut2() {
        if(isElementExist("getPwdTV")) {
            setHasRememberedAccount(false);
        } else {
            setHasRememberedAccount(true);
        }
    }


}
