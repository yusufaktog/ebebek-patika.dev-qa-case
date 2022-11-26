package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends Page {
    final By loginButtonLocator = By.id("lnkLoginNavNode");
    final By goToCartButtonLocator = By.id("account-menu-btn");

    final By cartProductNumberLocator = new By.ByClassName("span.number");

    final SearchBoxPage searchBox;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        searchBox = new SearchBoxPage(webDriver);
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


}
