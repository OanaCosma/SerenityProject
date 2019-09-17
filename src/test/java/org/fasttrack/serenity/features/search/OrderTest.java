package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.CartSteps;
import org.fasttrack.serenity.steps.serenity.CheckoutSteps;
import org.fasttrack.serenity.steps.serenity.LoginSteps;
import org.fasttrack.serenity.steps.serenity.OrdersSteps;
import org.fasttrack.serenity.utils.Constants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class OrderTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    @Steps
    private LoginSteps loginSteps;
    @Steps
    private CartSteps cartSteps;
    @Steps
    private CheckoutSteps checkoutSteps;
    @Steps
    private OrdersSteps ordersSteps;

    private String keyword="album";

    @Test
    public void orderProduct(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASSWORD);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
        cartSteps.searchForKeyword(keyword);
        cartSteps.addToCartProduct();
        cartSteps.navigateToCartPage();
        checkoutSteps.placeOrderProduct(Constants.FIRST_NAME, Constants.LAST_NAME,Constants.COUNTRY,
                Constants.STREET_ADDRESS, Constants.TOWN, Constants.COUNTY, Constants.POSTCODE,
                Constants.PHONE, Constants.USER_EMAIL);


    }

}
