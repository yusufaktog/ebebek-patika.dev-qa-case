package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends Page {

    final By competeTransactionButton = By.id("btnGoToShippingAddress");

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void completeTransaction() {
        findBy(competeTransactionButton).click();
    }
}
