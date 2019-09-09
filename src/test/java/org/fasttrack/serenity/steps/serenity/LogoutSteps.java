package org.fasttrack.serenity.steps.serenity;


import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.AccountPage;
import org.fasttrack.serenity.pages.LoginPage;
import org.junit.Assert;

public class LogoutSteps {
    private AccountPage accountPage;
    private LoginPage loginPage;

    @Step
    public void performLogout(){
        accountPage.clickLogoutLink();
    }
    @Step
    public void checkLogout(){
        Assert.assertTrue("The user is not logout",loginPage.verifyLogout());
    }

}
