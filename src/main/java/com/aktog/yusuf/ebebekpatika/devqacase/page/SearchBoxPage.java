package com.aktog.yusuf.ebebekpatika.devqacase.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchBoxPage extends Page {
    final By searchBoxLocator = By.id("txtSearchBox");

    public SearchBoxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void search(String key) {
        sendInput(searchBoxLocator, key);
        findBy(searchBoxLocator).sendKeys(Keys.ENTER);

    }


}
