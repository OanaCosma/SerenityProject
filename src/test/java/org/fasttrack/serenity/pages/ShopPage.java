package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa5.fasttrackit.org:8008/shop/")
public class ShopPage extends PageObject {
    @FindBy(css = ".search-field")
    private WebElementFacade searchField;

    public void setSearchField(String keyword){
        searchField.typeAndEnter(keyword);
    }




}


