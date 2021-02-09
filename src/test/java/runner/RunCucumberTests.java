package runner;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

import utility.Device;
import utility.User;
import utility.devices.Android;
import utility.devices.ClientModel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static utility.devices.ClientModel.*;


@CucumberOptions(features = {"classpath:features"}
        , tags = {"@regression"}
        , glue = {"stepdefinitions", "utility"}
        , plugin = {"pretty",
        "html:target/cucumber-reports/cucumber-pretty",
        "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
        "rerun:target/cucumber-reports/rerun-reports/rerun.txt"}
)

@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {
    static Object[][] userArray = {
            {"User", PIXEL3}
    };


    @BeforeMethod
    public static void setup() {
        System.out.println("tst");

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (Object[] s : userArray) {
            Device device = null;
            String user = (String) s[0];
            ClientModel clientModel = (ClientModel) s[1];
            User.users.put(user, new User(user));

            if (User.getUsers().get(user).getDevice() == null) {
                if (clientModel.getPlatformName().equalsIgnoreCase("android")) {
                    device = new Android(clientModel);
                    service.execute(device);
                }
            }

            User.getUsers()
                    .get(user)
                    .setDevice(device);
        }

        service.shutdown();
        try {
            if (service.awaitTermination(300, TimeUnit.SECONDS)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterMethod
    public static void teardown() {
        User.getUsers().forEach((k, v) -> {
            if (v.getDevice().getDriver() != null)
                v.getDevice().getDriver().quit();
        });
    }
}
