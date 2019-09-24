package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.AccountPage;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.LoginPage;

public class LoginSteps {
    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickMyAccountLink();
    }

    @Step
    public void performLogin(String email, String password){
        loginPage.setEmailLoginField(email);
        loginPage.setPasswordLoginField(password);
        loginPage.clickLoginButton();
    }
    @Step
    public void checkLoggedIn(String username){
        accountPage.verifyLoggedIn(username);
    }
    @Step
    public void checkNotLoggedInInvalidUserName(){
        loginPage.verifyNotLoggedInInvalidUserName();
    }
    @Step
    public void verifyNotLoggedInIncorrectPassword(){
        loginPage.checkNotLoggedInIncorrectPassword();
    }


    }
