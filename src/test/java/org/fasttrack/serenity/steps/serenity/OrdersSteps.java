package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.*;
import org.junit.Assert;
public class OrdersSteps {
    private HomePage homePage;
    private AccountPage accountPage;
    private OrdersPage ordersPage;
    private ViewOrderPage viewOrderPage;
    private OrderReceivedPage orderReceivedPage;

    @Step
    public void navigateToMyAccountPage(){
        homePage.clickMyAccountLink();
    }
    @Step
    public void verifyUserName(String username){
        accountPage.verifyLoggedIn(username);
    }
    @Step
    public void navigateToOrdersPage(){
        accountPage.clickOrdersLink();
    }

    @Step
    public void navigateToViewOrderPage(){
        ordersPage.clickViewOrderButton();
    }
    @Step
    public void compareProductName(){
        Assert.assertTrue(orderReceivedPage.getProductNameFromOrderReceived().equals(viewOrderPage.getProductNameFromViewOrder()));
    }

}