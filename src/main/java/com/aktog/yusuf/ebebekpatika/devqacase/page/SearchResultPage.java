package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultPage extends Page {
    public final By hasSearchBoxResultsLocator = By.className("has-searchbox-results");
    public final By productLocator = By.cssSelector("eb-product-list-item");
    public final By totalProductCountLocator = By.cssSelector("div.product-list-count");
    public final By stockCheckBoxLocator = By.id("chkStoktakiler");


    public SearchResultPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public String getSearchKey() {
        return this.webDriver.getCurrentUrl().split("search?text=")[1];
    }

    public boolean isOnSearchResultPage() {
        wait.until(ExpectedConditions.presenceOfElementLocated(hasSearchBoxResultsLocator));

        return isDisplayed(hasSearchBoxResultsLocator);
    }

    public WebElement getLastSearchResultElement() {

        var list = findAllBy(productLocator);
        return list.get(list.size() - 1);
    }

    public void filterByStock() {

        wait.until(
                webDriver -> {
                    try {
                        click(stockCheckBoxLocator);
                        return true;
                    } catch (StaleElementReferenceException e) {
                        return false;
                    }
                }
        );

    }

    public List<WebElement> getSearchResultList() {
        return findAllBy(productLocator);
    }

    public int getTotalProductCount() {
        String text = findBy(totalProductCountLocator).getText();
        return Integer.parseInt(text.split("adet")[0].trim());
    }

}
