package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.RegisterPage;
import org.junit.Assert;

public class RegisterSteps {
    private HomePage homePage;
    private RegisterPage registerPage;

    @Step
    public void navigateToRegisterPage(){
        homePage.open();
        homePage.clickMyAccountLink();
    }

    @Step
    public void performRegister(String email, String password){
        registerPage.setEmailField(email);
        registerPage.setPasswordField(password);
        registerPage.clickRegisterButton();
    }
    @Step
    public void checkRegistered(){
        Assert.assertTrue(registerPage.verifyRegister());
    }

    @Step
    public void checkNotRegisterTwiceSameEmail(){
        registerPage.verifyNotRegisterTwiceSameEmail();
    }


}

