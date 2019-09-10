package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.CartSteps;
import org.fasttrack.serenity.steps.serenity.ShopSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private ShopSteps shopSteps;
    @Steps
    private CartSteps cartSteps;


    private String keyword="beanie";
    private String quantity="5";

    @Test
    public void addProductToCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
    }
    @Test
    public void removeTheProductFromCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.chooseFirstProduct();
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
        cartSteps.removeProduct();
        cartSteps.verifyCartIsEmpty();

    }
    @Test
    public void verifyTotalPriceCalculationTest(){
        shopSteps.navigateToShopPage();
        shopSteps.sortShopProductsByDate();
        shopSteps.addProductToCart();
        shopSteps.navigateToCartPage();
        cartSteps.updateProductQuantityInCart(quantity);
        cartSteps.checkTotalPrice(quantity);
    }


}
