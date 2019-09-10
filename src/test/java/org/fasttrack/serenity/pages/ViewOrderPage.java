package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/my-account/view-order/")
public class ViewOrderPage extends PageObject {
    @FindBy(css=".order_item .product-name a")
    private WebElementFacade productName;
    String productNameFromViewOrder;

    public String getProductNameFromViewOrder(){
        return productNameFromViewOrder = productName.getText();
    }

}

