package com.aktog.yusuf.ebebekpatika.devqacase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplicationTests extends BaseTest {

    @Test
    @Order(1)
    public void testDoSearch() {

        homePage.closePopUp();

        homePage.getSearchBox().search("kaşık maması");

        Assertions.assertTrue(searchResultPage.isOnSearchResultPage());
    }

    @Test
    @Order(2)
    public void testClickLastSearchResult() {

        searchResultPage.filterByStock();

        new WebDriverWait(webDriver, Duration.ofSeconds(10)).until(
                webDriver -> {

                    if (searchResultPage.getSearchResultList().size() >= searchResultPage.getTotalProductCount()) {
                        return true;
                    } else {
                        jse.executeScript("window.scrollTo(0, 0.75 * document.body.scrollHeight)");
                        return false;
                    }
                }
        );

        WebElement element = searchResultPage.getLastSearchResultElement();
        String titleBeforeClick = element.getText();

        element.click();

        String titleAfterClick = productPage.getProductTitle();

        Assertions.assertTrue(titleBeforeClick.contains(titleAfterClick));
    }

    @Test
    @Order(3)
    public void testGoToCart() {
        productPage.addToCart();

        productPage.goToCart();

        Assertions.assertTrue(cartPage.isOnCartPage());

    }

    @Test
    @Order(4)
    public void testCompleteTransaction() {

        cartPage.completeTransaction();

        Assertions.assertTrue(loginPage.isOnLoginPage());

    }
}