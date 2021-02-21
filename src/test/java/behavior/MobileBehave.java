package behavior;

import core.User;
import pages.Mobile.LoginPage;

public abstract class MobileBehave implements Yanimda {

    @Override
    public void vfLogin(User user) throws Exception {
        new LoginPage(user)
                .vfLogin();
    }
}
