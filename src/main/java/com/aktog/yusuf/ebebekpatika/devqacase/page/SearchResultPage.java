package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends Page {
    public final By hasSearchBoxResultsLocator = new By.ByClassName("has-searchbox-results");
    public final By productLocator = By.cssSelector("eb-product-list-item");
    public final By hasStockCheckBoxLocator = By.id("chkStoktakiler");
    public final By totalProductCountLocator = By.cssSelector("div.product-list-count");

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

        var list = findAllBy(productLocator);
        return list.get(list.size() - 1);
    }
    public void filterByStock() {
        click(hasStockCheckBoxLocator);
    }
    public List<WebElement> getSearchResultList() {
        return findAllBy(productLocator);
    }
    public int getTotalProductCount() {
        String text = findBy(totalProductCountLocator).getText();
        return Integer.parseInt(text.split("adet")[0].trim());
    }
}
