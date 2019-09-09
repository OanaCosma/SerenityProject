package org.fasttrack.serenity.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/my-account/")
public class LoginPage extends PageObject {
    @FindBy(id="username")
    private WebElementFacade emailLoginField;
    @FindBy(id="password")
    private WebElementFacade passwordLoginField;
    @FindBy(css=".login .form-row .woocommerce-Button.button")
    private WebElementFacade loginButton;
    @FindBy(css=".woocommerce-error li strong")
    private WebElementFacade errorUserNameLoginMessage;
    @FindBy(css=".widget.widget_meta li:nth-child(2) a")
    private WebElementFacade loginLink;



    public void setEmailLoginField(String email){
        typeInto(emailLoginField, email);
    }
    public void setPasswordLoginField(String password){
        typeInto(passwordLoginField, password);
    }
    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public void verifyNotLoggedInInvalidUserName(){
        errorUserNameLoginMessage.shouldContainText("ERROR" );
    }
    public boolean verifyLogout(){
        return loginLink.isCurrentlyVisible();
    }



}

