package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Page {

    protected final WebDriver webDriver;
    protected final WebDriverWait wait;

    public Page(WebDriver webDriver, WebDriverWait wait) {
        this.webDriver = webDriver;
        this.wait = wait;
    }

    public WebElement findBy(By locator) {
        return webDriver.findElement(locator);
    }

    public List<WebElement> findAllBy(By locator) {
        return webDriver.findElements(locator);
    }

    public void click(By locator) {
        findBy(locator).click();
    }

    public void sendInput(By locator, String input) {
        findBy(locator).sendKeys(input);
    }

    public boolean isDisplayed(By locator) {
        return findBy(locator).isDisplayed();
    }
}
