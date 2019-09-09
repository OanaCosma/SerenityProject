package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {
    @FindBy(css=".menu a[href*='my-account']")
    private WebElementFacade myAccount;
    @FindBy(css=".menu a[href*='shop']")
    private WebElementFacade shopLink;
    @FindBy(css=".menu a[href*='login']")
    private WebElementFacade loginLink;

    public void clickMyAccount(){
        clickOn(myAccount);
    }

    public void clickShopLink(){
        clickOn(shopLink);
    }

    public void clickLogInLink(){
        clickOn(loginLink);
    }

}

