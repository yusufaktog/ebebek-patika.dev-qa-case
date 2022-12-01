package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends Page {

    final By competeTransactionButtonLocator = By.id("btnGoToShippingAddress");

    public CartPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
    }

    public void completeTransaction() {

        wait.until(ExpectedConditions.elementToBeClickable(competeTransactionButtonLocator));

        findBy(competeTransactionButtonLocator).click();
    }

    public boolean isOnCartPage() {

        wait.until(ExpectedConditions.presenceOfElementLocated(competeTransactionButtonLocator));

        return findBy(competeTransactionButtonLocator).isDisplayed();
    }
}
