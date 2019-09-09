package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

public class LoginTest {
    @RunWith(SerenityRunner.class)


        @Managed(uniqueSession = true)
        private WebDriver driver;

        @Before
        public void maximizeWindow(){
            driver.manage().window().maximize(); }
        @Steps
        private LoginSteps loginSteps;

        @Test
        public void validLogin(){
            loginSteps.navigateToLoginPage();
            loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
            loginSteps.checkLoggedIn(Constants.USER_NAME);
        }
        @Test
        public void invalidUserNameLogin() {
            loginSteps.navigateToLoginPage();
            loginSteps.performLogin("madison", Constants.USER_PASSWORD);
            loginSteps.checkNotLoggedInInvalidUserName();
        }
    }


