package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.LoginSteps;
import org.fasttrack.serenity.steps.serenity.RegisterSteps;
import org.fasttrack.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class RegisterTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private RegisterSteps registerSteps;


    @Test
    public void validRegister(){
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        registerSteps.checkRegistered();
    }

    @Test
    public void registerTwiceWithTheSameEmailTest() {
        registerSteps.navigateToRegisterPage();
        registerSteps.performRegister(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        registerSteps.checkNotRegisterTwiceSameEmail();
    }

}

