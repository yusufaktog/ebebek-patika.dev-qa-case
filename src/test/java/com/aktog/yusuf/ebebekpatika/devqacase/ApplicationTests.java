package com.aktog.yusuf.ebebekpatika.devqacase;

import com.aktog.yusuf.ebebekpatika.devqacase.page.CartPage;
import com.aktog.yusuf.ebebekpatika.devqacase.page.HomePage;
import com.aktog.yusuf.ebebekpatika.devqacase.page.ProductPage;
import com.aktog.yusuf.ebebekpatika.devqacase.page.SearchResultPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

public class ApplicationTests extends BaseTest {

    HomePage homePage;
    ProductPage productPage;
    SearchResultPage searchResultPage;
    CartPage cartPage;

    /*
* WebElement searchBox = webDriver.findElement(By.id("txtSearchBox"));

        searchBox.sendKeys("kaşık maması");

        searchBox.sendKeys(Keys.ENTER);

        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(
                webDriver1 -> webDriver1.findElement(By.className("has-searchbox-results")).isDisplayed()
        );

        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(
                webDriver1 -> !webDriver1.findElements(By.className("product-item-anchor")).isEmpty()
        );

        JavascriptExecutor jse = (JavascriptExecutor) webDriver;
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        var list = webDriver.findElements(By.className("product-item-anchor")).stream().filter(webElement -> webElement.findElement(By.className("btn-buttonload")).getText().equalsIgnoreCase("tükendi"));


        list.forEach(webElement -> System.out.println("== " + webElement.getAccessibleName()));
        * */


    @Test
    @Order(1)
    public void testDoSearch() {
        homePage = new HomePage(webDriver);
        searchResultPage = new SearchResultPage(webDriver);

        homePage.getSearchBox().search("kaşık maması");

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(
                webDriver -> searchResultPage.isOnSearchResultPage()
        );

        Assertions.assertTrue(searchResultPage.isOnSearchResultPage());
    }

    @Test
    @Order(2)
    public void testClickLastSearchResult() {
        searchResultPage.getLastSearchResultElement().click();

        productPage = new ProductPage(webDriver);

        productPage.addToCart();
    }
}
