package com.aktog.yusuf.ebebekpatika.devqacase;

import com.aktog.yusuf.ebebekpatika.devqacase.page.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationTests extends BaseTest {



    @Test
    @Order(1)
    public void testDoSearch() {

        homePage.getSearchBox().search("kaşık maması");

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                webDriver -> searchResultPage.isOnSearchResultPage()
        );

        Assertions.assertTrue(searchResultPage.isOnSearchResultPage());
    }

    @Test
    @Order(2)
    public void testClickLastSearchResult() {

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                webDriver -> !searchResultPage.getSearchResultList().isEmpty()
        );

        try {
            searchResultPage.filterByStock();
        } catch (StaleElementReferenceException | ElementClickInterceptedException ignored) {
            searchResultPage.filterByStock();
        }

            new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
                    webDriver -> {
                        jse.executeScript("window.scrollTo(0, document.body.scrollHeight - 10)");
                        return searchResultPage.getSearchResultList().size() >= searchResultPage.getTotalProductCount();
                    }
            );

        WebElement element = searchResultPage.getLastSearchResultElement();
        String titleBeforeClick = element.getText();

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                webDriver -> jse.getPinnedScripts().size() == 0
        );

        try {
            searchResultPage.getLastSearchResultElement().click();
        } catch (ElementClickInterceptedException e) {
            searchResultPage.getLastSearchResultElement().click();
        }


        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                webDriver -> productPage.isOnProductPage()
        );

        String titleAfterClick = productPage.getProductTitle();

        Assertions.assertTrue(titleBeforeClick.contains(titleAfterClick));
    }

    @Test
    @Order(3)
    public void testValidateClickedProduct() {

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(
                webDriver -> productPage.isAddToChartButtonDisplayed()
        );

        productPage.addToCart();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(
                webDriver -> productPage.isGoToChartButtonDisplayed()
        );

        productPage.goToCart();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(
                webDriver -> cartPage.isOnCartPage());

        cartPage.completeTransaction();

        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(
                webDriver -> loginPage.isOnLoginPage());

        Assertions.assertTrue(loginPage.isOnLoginPage());

    }
}