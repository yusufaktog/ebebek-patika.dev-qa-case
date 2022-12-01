package com.aktog.yusuf.ebebekpatika.devqacase;

import com.aktog.yusuf.ebebekpatika.devqacase.log.TestResultLogger;
import com.aktog.yusuf.ebebekpatika.devqacase.page.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    protected WebDriver webDriver;
    protected JavascriptExecutor jse;
    protected HomePage homePage;
    protected ProductPage productPage;
    protected SearchResultPage searchResultPage;
    protected CartPage cartPage;
    protected LoginPage loginPage;
    protected WebDriverWait wait;

    @BeforeAll
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.e-bebek.com/");
        webDriver.manage().window().maximize();

        jse = (JavascriptExecutor) webDriver;

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));

        homePage = new HomePage(webDriver, wait);
        searchResultPage = new SearchResultPage(webDriver, wait);
        productPage = new ProductPage(webDriver, wait);
        cartPage = new CartPage(webDriver, wait);
        loginPage = new LoginPage(webDriver, wait);

    }

    @AfterAll
    public void tearDown() {
        webDriver.quit();
    }
}