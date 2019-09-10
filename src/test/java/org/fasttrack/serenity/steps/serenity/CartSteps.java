package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.*;
import org.junit.Assert;

public class CartSteps {
    private HomePage homePage;
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

    @Step
    public void navigateToShopPage(){
        homePage.open();
        homePage.clickShopLink();
    }
    @Step
    public void searchForKeyword(String keyword) {
        shopPage.setSearchField(keyword);
    }
    @Step
    public void chooseFirstProduct(){
        searchPage.clickFirstProductLink();
    }
    @Step
    public void addToCartProduct(){
        productPage.clickAddToCartButton();
    }
    @Step
    public void checkProductinCart(){
        productPage.clickViewCartButton();
        Assert.assertTrue(cartPage.verifyProductSentToCart());
    }

}

