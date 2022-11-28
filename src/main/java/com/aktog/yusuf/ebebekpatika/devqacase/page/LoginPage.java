package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    final By loginButtonLocator = By.id("btnSubmitLogin");
    final By phoneTextLocator = By.id("txtPhoneNumberMobile");


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getLoginButton() {
        return findBy(loginButtonLocator);
    }

    public WebElement getPhoneTextInput() {
        return findBy(phoneTextLocator);
    }

    public boolean isOnLoginPage(){
        return findBy(phoneTextLocator).isDisplayed();
    }
}
