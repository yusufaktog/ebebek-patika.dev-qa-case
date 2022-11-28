package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Page {

    public final WebDriver webDriver;

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
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
