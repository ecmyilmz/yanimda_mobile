package core;

import behavior.Yanimda;
import core.devices.ClientModel;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public abstract class Device implements Runnable {

    protected final String APPIUM_SERVER = "http://127.0.0.1:4723/wd/hub";
    protected final int NEW_COMMAND_TIMEOUT = 150000;
    public WebDriver driver;
    protected ClientModel clientModel;
    public abstract void startDriver();
    protected Yanimda yanimda;
    protected User user;
    private Properties selectors;

    public void switch_to_native_view() {
        Set<String> contextNames = ((AndroidDriver) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE_APP"))
                ((AndroidDriver) driver).context(contextName);
        }
    }

    public Yanimda getYanimda() {
        return yanimda;
    }
    public void setYanimda(Yanimda yanimda) { this.yanimda = yanimda; }

    @Override
    public void run() {
        startDriver();
        //sleepms(10000);
    }

    public abstract void closeApp();

    public WebDriver getDriver() {
        return driver;
    }

    public ClientModel getClientModel() {
        return clientModel;
    }
    public Device() {
        selectors = new Properties();
        try {
            selectors.load(Device.class.getResourceAsStream("/selectors/selector.properties"));
        } catch (IOException e) {
        }
    }
    public User getUser() { return user; }

}
