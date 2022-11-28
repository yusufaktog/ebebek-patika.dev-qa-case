package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends Page {

    By addToCartButtonLocator = By.id("addToCartBtn");
    By productTitleLocator = By.id("txtProductTitle");
    By goToChartLocator = By.id("btnShowCart");


    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void addToCart() {
        click(addToCartButtonLocator);
    }

    public String getProductTitle() {
        return findAllBy(productTitleLocator).get(1).getText();
    }

    public boolean isOnProductPage() {
        return findAllBy(productTitleLocator).size() > 0;
    }

    public void goToCart() {
        click(goToChartLocator);
    }

    public boolean isAddToChartButtonDisplayed(){
        return findBy(addToCartButtonLocator).isDisplayed();
    }

    public boolean isGoToChartButtonDisplayed() {
        return  findBy(goToChartLocator).isDisplayed();
    }
}
