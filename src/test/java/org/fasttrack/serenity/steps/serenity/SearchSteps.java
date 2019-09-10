package org.fasttrack.serenity.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.SearchPage;
import org.fasttrack.serenity.pages.ShopPage;
import org.junit.Assert;

public class SearchSteps {

    private HomePage homePage;
    private ShopPage shopPage;
    private SearchPage searchPage;

    @Step
    public void navigateToShopPage(){
        homePage.open();
        homePage.clickShopLink();
    }
    @Step
    public void searchForKeyword(String keyword){
        shopPage.setSearchField(keyword);
    }
    @Step
    public void checkSearchResultMessage(String keyword){
        searchPage.verifySearchResultsMessage(keyword);
    }
    @Step
    public void checkNothingFoundSearchResultMessage(){
        Assert.assertTrue(searchPage.verifyNothingFoundSearchResultMessage());
    }
}
