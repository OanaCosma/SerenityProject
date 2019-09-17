package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends PageObject {
    @FindBy(css="#title_bread_wrap")
    private WebElementFacade searchResultsMessage;
    @FindBy(css="#primary > div")
    private WebElementFacade nothingFoundSearchResultMessage;
    @FindBy(css="#primary > div > div.wc-products > ul > li.post-44.product.type-product.status-publish.has-post-thumbnail.product_cat-clothing.instock.sale.shipping-taxable.product-type-grouped > div.collection_desc.clearfix > div > a")
    private WebElementFacade firstProduct;


    public void verifySearchResultsMessage(String keyword){
        searchResultsMessage.shouldContainText("Search Results for: "+ keyword);
    }
    public boolean verifyNothingFoundSearchResultMessage(){
        return nothingFoundSearchResultMessage.containsOnlyText("No products were found matching your selection. " +
                "Please try again with some different keywords.");
    }
    public void clickFirstProductLink(){
        clickOn(firstProduct);
    }

}
