package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class MyAccountPageTest extends BaseTest {

    private WebDriver driver;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void setUp() {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserNames.CHROME); //implementation for ENUM
        myAccountPage = new MyAccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.killDriverInstance();
    }
}
