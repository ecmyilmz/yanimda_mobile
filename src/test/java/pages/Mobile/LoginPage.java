package pages.Mobile;


import core.User;
import org.openqa.selenium.By;
import pages.MainPage;

public class LoginPage extends MainPage {
    private final By  VF_LOGIN = By.cssSelector("#vFCardBTN");


    public LoginPage(User user) {
        super(user);
    }

    public LoginPage vfLogin() throws Exception {
        tap(VF_LOGIN);
        return this;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
