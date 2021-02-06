package utility.devices;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import utility.Device;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Android extends Device {
    private final String ANDROID_APP_PACKAGE = "com.vodafone.selfservis.beta";
    private final String APP_ACTIVITY = "com.vodafone.selfservis.modules.splash.activities.SplashActivity";
    private final int ADB_TIMEOUT = 60 * 1000;

    public Android(ClientModel model) {
        this.clientModel = model;
    }

    @Override
    public void startDriver() {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.UDID, clientModel.getUdid());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, clientModel.name());
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, clientModel.getPlatformVersion());
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ANDROID_APP_PACKAGE);
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        cap.setCapability(AndroidMobileCapabilityType.UNICODE_KEYBOARD, true);
        cap.setCapability(AndroidMobileCapabilityType.RESET_KEYBOARD, true);
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, NEW_COMMAND_TIMEOUT);
        cap.setCapability(MobileCapabilityType.NO_RESET, true);
        cap.setCapability("adbExecTimeout", ADB_TIMEOUT);
        cap.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, clientModel.getPort());
        try {
            URL url = new URL(APPIUM_SERVER);
            driver = new AndroidDriver<>(url, cap);
        } catch (Exception e) {
            if (driver == null)
                System.out.println("DEBUG: driver was null");
            System.out.println("Exception in Android.Java at line 54");
            e.printStackTrace();
        }
    }

    @Override
    public void closeApp() {
        List<String> lsArgs = Arrays.asList(ANDROID_APP_PACKAGE);
        Map<String, Object> lsCmd = ImmutableMap.of(
                "command", "am force-stop",
                "args", lsArgs
        );
        switch_to_native_view();
        ((AndroidDriver) driver).executeScript("mobile: shell", lsCmd);
    }
}