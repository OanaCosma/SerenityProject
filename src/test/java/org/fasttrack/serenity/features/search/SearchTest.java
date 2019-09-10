package org.fasttrack.serenity.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.serenity.SearchSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class SearchTest {
    @Managed(uniqueSession = true)
    private WebDriver driver;
    @Before
    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private SearchSteps searchSteps;

    private String keyword="hoodie";

    @Test
    public void searchForAValidKeywordTest(){
        searchSteps.navigateToShopPage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.checkSearchResultMessage(keyword);
    }
    @Test
    public void searchForANonValidKeywordTest(){
        searchSteps.navigateToShopPage();
        searchSteps.searchForKeyword(keyword);
        searchSteps.checkNothingFoundSearchResultMessage();
    }

}
