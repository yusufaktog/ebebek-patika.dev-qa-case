package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Page {

    By addToCartButtonLocator = By.id("addToCartBtn");
    By productTitleLocator = By.id("txtProductTitle");
    By goToChartLocator = By.id("btnShowCart");

    public ProductPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void addToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(addToCartButtonLocator));

        click(addToCartButtonLocator);
    }

    public String getProductTitle() {

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(productTitleLocator,0));

        return findAllBy(productTitleLocator).get(1).getText();
    }

    public boolean isOnProductPage() {
        return findAllBy(productTitleLocator).size() > 0;
    }

    public void goToCart() {

        wait.until(ExpectedConditions.elementToBeClickable(goToChartLocator));

        click(goToChartLocator);
    }

    public boolean isAddToChartButtonDisplayed() {
        return findBy(addToCartButtonLocator).isDisplayed();
    }

    public boolean isGoToChartButtonDisplayed() {
        return findBy(goToChartLocator).isDisplayed();
    }
}
