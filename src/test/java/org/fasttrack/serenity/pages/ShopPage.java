package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://qa5.fasttrackit.org:8008/shop/")
public class ShopPage extends PageObject {
    @FindBy(css = ".search-field")
    private WebElementFacade searchField;
    @FindBy(css=".products.columns-3 li")
    private List<WebElementFacade> listOfProducts;
    @FindBy(css=".next.page-numbers")
    private WebElementFacade nextPageLink;
    @FindBy(css=".orderby")
    private WebElementFacade sortbyDropDown;
    @FindBy(css=".products li:first-child .add_to_cart_button")
    private WebElementFacade firstProductAddToCartButton;
    @FindBy(css="#primary-menu .cart-contents")
    private WebElementFacade viewShoppingCartLink;

    private int count=0;

    public void setSearchField(String keyword){
        searchField.typeAndEnter(keyword);
    }

    public boolean verifyAddToCartButtonsAreVisible() {
        do {
            for (WebElementFacade product : listOfProducts) {
                if (!product.findElement(By.cssSelector("a:nth-child(2)")).getText().equals("Add to cart")) {
                    count += 1;
                }
            }
            clickOn(nextPageLink);
        }
        while (nextPageLink.isVisible()) ;
        return count==0;
    }

    public void sortProductsByDate(){
        selectFromDropdown(sortbyDropDown,"Sort by newness");
    }
    public void clickAddToCartButtonFirstProduct(){
        clickOn(firstProductAddToCartButton);
    }
    public void clickViewShoppingCartLink(){
        waitABit(5000);
        clickOn(viewShoppingCartLink);
    }

}

