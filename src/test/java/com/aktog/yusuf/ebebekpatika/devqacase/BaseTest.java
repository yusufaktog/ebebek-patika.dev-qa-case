package com.aktog.yusuf.ebebekpatika.devqacase;

import com.aktog.yusuf.ebebekpatika.devqacase.page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BaseTest {

    protected WebDriver webDriver;
    protected JavascriptExecutor jse;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected SearchResultPage searchResultPage;
    protected CartPage cartPage;
    protected LoginPage loginPage;

    @BeforeAll
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.e-bebek.com/");
        webDriver.manage().window().maximize();

        jse = (JavascriptExecutor) webDriver;
        homePage = new HomePage(webDriver);
        searchResultPage = new SearchResultPage(webDriver);
        productPage = new ProductPage(webDriver);
        cartPage = new CartPage(webDriver);
        loginPage = new LoginPage(webDriver);

    }

    @AfterAll
    public void tearDown(){
        webDriver.quit();
    }
}