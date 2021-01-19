package com.automationpracticetest;

import com.automationpractice.MyAccountPage;
import com.utils.TestListener;
import com.utils.WebDriverSingleton;
import com.utils.BrowserNames;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)

public class MyAccountPageTest extends BaseTest {

    private WebDriver driver;
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void setUp() {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = WebDriverSingleton.getDriver(BrowserNames.CHROME); //implementation for ENUM
        myAccountPage = new MyAccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.killDriverInstance();
    }
}
