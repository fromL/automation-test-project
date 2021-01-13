package com.automationpracticetest;

import com.automationpractice.LogInPage;
import com.automationpractice.MainPage;
import com.automationpractice.TestListener;
import com.automationpractice.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)

public class MainPageTest extends BaseTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeMethod
    public void setUp2() {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserNames.CHROME); //implementation for ENUM
        mainPage = new MainPage(driver);
        System.out.println("BeforeMethod from MainPageTest");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.killDriverInstance();
    }

    @Test
    public void openingLogInPageTest() {
        LogInPage newLogInPage = mainPage
                .openMainPage()
                .clickSignInButtonMainPage();
        String headingLogInPage = newLogInPage.getHeadingLogInPage();
        Assert.assertEquals(
                headingLogInPage,
                "AUTHENTICATION1",
                "Log In page heading is incorrect!!!"
        );


    }

}
