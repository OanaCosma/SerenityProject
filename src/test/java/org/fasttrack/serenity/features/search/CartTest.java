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


    private String keyword="belt";
    private String quantity="7";


    @Test
    public void addProductToCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
    }


    @Test
    public void removeTheProductFromCartTest(){
        shopSteps.navigateToShopPage();
        cartSteps.searchForKeyword(keyword);
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        cartSteps.checkProductinCart();
        cartSteps.removeProduct();
        cartSteps.verifyCartIsEmpty();

    }
    @Test
    public void verifyTotalPriceCalculationTest(){
        shopSteps.navigateToShopPage();
        shopSteps.sortShopProductsByNewness();
        shopSteps.addProductToCart();
        shopSteps.navigateToCartPage();
        cartSteps.updateProductQuantityInCart(quantity);
        cartSteps.checkTotalPrice(quantity);
    }


}
