package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class SearchPage extends PageObject {
    @FindBy(css=".page-title")
    private WebElementFacade searchResultsMessage;
    @FindBy(css=".page-content p")
    private WebElementFacade nothingFoundSearchResultMessage;
    @FindBy(css="article:nth-child(2) h1 a")
    private WebElementFacade firstProduct;


    public void verifySearchResultsMessage(String keyword){
        searchResultsMessage.shouldContainText("Search Results for: "+ keyword);
    }
    public boolean verifyNothingFoundSearchResultMessage(){
        return nothingFoundSearchResultMessage.containsOnlyText("Sorry, but nothing matched your search terms. " +
                "Please try again with some different keywords.");
    }
    public void clickFirstProductLink(){
        clickOn(firstProduct);
    }

}
