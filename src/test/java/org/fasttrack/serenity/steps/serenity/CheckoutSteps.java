package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.CartPage;
import org.fasttrack.serenity.pages.CheckoutPage;
import org.fasttrack.serenity.pages.OrderReceivedPage;

public class CheckoutSteps {
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private OrderReceivedPage orderReceivedPage;


    @Step
    public void placeOrderProduct(String firstName, String lastName,String country, String street, String city, String county, String postcode, String phone, String email) {
        cartPage.clickProceedToCheckoutButton();
        checkoutPage.setFirstNameField(firstName);
        checkoutPage.setLastNameField(lastName);
        checkoutPage.selectCountry(country);
        checkoutPage.setStreetField(street);
        checkoutPage.setCityField(city);
        checkoutPage.selectCounty(county);
        checkoutPage.setPostcodeField(postcode);
        checkoutPage.setPhoneField(phone);
        checkoutPage.setEmailField(email);
        checkoutPage.clickPlaceOrderButton();
    }
    @Step
    public void verifyProductPlacedInOrder(){
        orderReceivedPage.checkOrderReceivedMessage();
    }

}
