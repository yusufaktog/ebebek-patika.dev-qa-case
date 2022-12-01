package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page {
    final By loginButtonLocator = By.id("lnkLoginNavNode");
    final By goToCartButtonLocator = By.id("account-menu-btn");
    final By cartProductNumberLocator = new By.ByClassName("span.number");
    final SearchBoxPage searchBox;

    public HomePage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver, wait);
        searchBox = new SearchBoxPage(webDriver, wait);
    }

    public SearchBoxPage getSearchBox() {
        return this.searchBox;
    }

    public void goToCart() {
        click(goToCartButtonLocator);
    }

    public void goToLoginPage() {
        click(loginButtonLocator);
    }

    public int getCartCount() {
        return Integer.parseInt(findAllBy(cartProductNumberLocator).get(0).getText());
    }

    public void closePopUp() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.className("ins-close-button-container-c2703"))).click();

        } catch (TimeoutException ignored) {

        }
    }

}
