package org.fasttrack.serenity.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/cart/")
public class CartPage extends PageObject {
    @FindBy(css=".checkout-button")
    private WebElementFacade proceedToCheckoutButton;

    public boolean verifyProductSentToCart(){
        return proceedToCheckoutButton.isClickable();
    }
    public void clickProceedToCheckoutButton(){
        clickOn(proceedToCheckoutButton);
    }
}
