package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {
    final By loginButtonLocator = By.id("btnSubmitLogin");
    final By phoneTextLocator = By.id("txtPhoneNumberMobile");

    public LoginPage(WebDriver webDriver, WebDriverWait wait) {
        super(webDriver,wait);
    }

    public WebElement getLoginButton() {
        return findBy(loginButtonLocator);
    }

    public WebElement getPhoneTextInput() {
        return findBy(phoneTextLocator);
    }

    public boolean isOnLoginPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(phoneTextLocator));
        return findBy(phoneTextLocator).isDisplayed();
    }
}
