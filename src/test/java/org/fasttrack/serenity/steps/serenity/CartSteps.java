package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.CartPage;
import org.fasttrack.serenity.pages.ProductPage;
import org.fasttrack.serenity.pages.SearchPage;
import org.fasttrack.serenity.pages.ShopPage;
import org.junit.Assert;

public class CartSteps {
    private ShopPage shopPage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;

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
    public void addToCartSecondProduct(){
        productPage.clickAddToCartButton();
    }
    @Step
    public void navigateToCartPage() {
        productPage.clickViewCartButton();
    }

    @Step
    public void checkProductinCart(){
        Assert.assertTrue(cartPage.verifyProductSentToCart());
    }
    @Step
    public void updateProductQuantityInCart(String quantity){
        cartPage.selectQuantity(quantity);
        cartPage.clickUpdateCartButton();
    }

    @Step
    public void checkTotalPrice(String quantity){
        Assert.assertTrue(cartPage.verifyTotalPrice(quantity));
    }

    @Step
    public void removeProduct(){
        cartPage.clickProductRemoveLink();
    }
    @Step
    public void verifyCartIsEmpty(){
        Assert.assertTrue("The product is not removed form the cart",cartPage.checkCartEmpty());
    }


}
