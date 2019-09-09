package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.LoginSteps;
import org.fasttrack.serenity.steps.serenity.LogoutSteps;
import org.fasttrack.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LogoutTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private LogoutSteps logoutSteps;

    @Test
    public void logoutTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
        logoutSteps.performLogout();
        logoutSteps.checkLogout();
    }

}
