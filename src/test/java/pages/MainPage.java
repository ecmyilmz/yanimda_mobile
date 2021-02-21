package pages;

import core.Device;
import core.User;
import core.devices.ClientModel;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.function.Function;

public abstract class MainPage extends LoadableComponent {
    private Properties selectors;
    protected User user;
    protected Device device;
    protected WebDriver driver;
    private String title;

    public void setDriver(String user) {
        driver = User.getUsers()
                .get(user)
                .getDevice()
                .getDriver();
    }

    public MainPage(User user) {
        selectors = new Properties();
        this.user = user;
        this.device = user.getDevice();
        this.driver = user.getDevice().getDriver();

        try {
            title = driver.getTitle();
        } catch (Exception e) {
            title = "No title";
        }
    }

    public String getTitle() {
        return title;
    }

    public <T> void tap(T p) throws Exception {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .ignoring(ElementNotVisibleException.class)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(TimeoutException.class)
                .ignoring(WebDriverException.class)
                .ignoring(ElementClickInterceptedException.class);
        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                WebElement el = null;
                if (p instanceof By) {
                    el = driver.findElement((By) p);
                } else if (p instanceof WebElement) {
                    el = ((WebElement) p);
                }else if (p instanceof String){
                    el = (WebElement) ((JavascriptExecutor)driver).executeScript("return "+String.valueOf(p));
                    if (el == null)
                        return null;
                }

                new WebDriverWait(driver, 3)
                        .until(ExpectedConditions.elementToBeClickable(el));
                assert el != null;
                el.click();
                return el; }});
    }


}
