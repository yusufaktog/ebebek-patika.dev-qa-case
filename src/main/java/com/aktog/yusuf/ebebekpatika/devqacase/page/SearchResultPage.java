package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends Page {
    final By hasSearchBoxResultsLocator = new By.ByClassName("has-searchbox-results");
    final By productLocator = By.className("product-item-anchor");
    final By hasStockCheckBoxLocator = By.id("chkStoktakiler");

    public SearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getSearchKey() {
        return this.webDriver.getCurrentUrl().split("search?text=")[1];
    }

    public boolean isOnSearchResultPage() {
        return this.isDisplayed(hasSearchBoxResultsLocator);
    }

    public WebElement getLastSearchResultElement() {
        findBy(hasStockCheckBoxLocator).click();

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        var list = findAllBy(productLocator);
        return list.get(list.size() - 1);
    }
}
