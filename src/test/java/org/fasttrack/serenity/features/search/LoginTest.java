package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.LoginSteps;
import org.fasttrack.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }
    @Steps
    private LoginSteps loginSteps;

    @Test
    public void validLoginTest(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL,Constants.USER_PASSWORD);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
    }
    @Test
    public void invalidUserNameLoginTest() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin("oana", Constants.USER_PASSWORD);
        loginSteps.checkNotLoggedInInvalidUserName();
    }
}


