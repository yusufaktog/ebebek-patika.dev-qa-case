package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Page {

    By addToCartButtonLocator = By.id("addToCartBtn");

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isOnProductDetailPage() {
        return isDisplayed(addToCartButtonLocator);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }


    public boolean isOnProductPage() {
        // validate the product with text
// arilac-sutlu-muzlu-kasik-mamasi-200-g-p-ari-6193
        return true;
    }
}
