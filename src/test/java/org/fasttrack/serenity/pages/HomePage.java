package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {
    @FindBy(css=".menu a[href*='page_id=7']")
    private WebElementFacade myAccountLink;
    @FindBy(css="#menu-item-73 > a")
    private WebElementFacade shopLink;


    public void clickMyAccountLink(){
        clickOn(myAccountLink);
    }

    public void clickShopLink(){
        clickOn(shopLink);
    }

}


