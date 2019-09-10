package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.ShopPage;
import org.junit.Assert;

public class ShopSteps {
    private HomePage homePage;
    private ShopPage shopPage;

    @Step
    public void navigateToShopPage(){
        homePage.open();
        homePage.clickShopLink();
    }
    @Step
    public void checkAddToCartButtons(){
        Assert.assertTrue("Not all product have Add to cart button visible on shop page.",
                shopPage.verifyAddToCartButtonsAreVisible());
    }
    @Step
    public void sortShopProductsByDate(){
        shopPage.sortProductsByDate();
    }
    @Step
    public void addProductToCart(){
        shopPage.clickAddToCartButtonFirstProduct();
    }
    @Step
    public void navigateToCartPage(){
        shopPage.clickViewShoppingCartLink();
    }
}

