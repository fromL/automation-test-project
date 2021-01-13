package com.automationpracticetest;

import com.automationpractice.LogInPage;
import com.automationpractice.MyAccountPage;
import com.automationpractice.WebDriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInPageTest extends BaseTest {

    private WebDriver driver;
    private LogInPage loginPage;

    @BeforeMethod
    public void setUp2() {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserNames.CHROME); //implementation for ENUM
        loginPage = new LogInPage(driver);
        System.out.println("BeforeMethod from LogInPageTest");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.killDriverInstance();
    }

    @Test
    public void loginWithInvalidCreds() {
        loginPage
                .openLogInPage()
                .logInOperation("asd@ddd.dddfd", "sdsdsdsadasdaasdeasf");
        String logInPageFailedAuthenticationHeading1 = loginPage.getLogInPageFailedAuthenticationHeading();
        Assert.assertEquals(
                logInPageFailedAuthenticationHeading1,
                "There is 1 error\n" +
                "Authentication failed.",
                "Error message is incorrect!!!");
    }

    @Test
    public void loginWithValidCreds() {
//        String myAccountPageWelcomeInfo1 = loginPage.openLogInPage().logInOperation("oleg.z@test.com", "testpassword").getMyAccountWelcomeInfo();
//        Assert.assertEquals(
//                myAccountPageWelcomeInfo1,
//                "Welcome to your account. Here you can manage all of your personal information and orders.",
//                "Message on My Account page is incorrect!!!"
//        );


        MyAccountPage newMyAccountPage = loginPage
                .openLogInPage()
                .logInOperation("oleg.z@test.com", "testpassword");
        String myAccountPageWelcomeInfo1 = newMyAccountPage.getMyAccountWelcomeInfo();
        Assert.assertEquals(
                myAccountPageWelcomeInfo1,
                "Welcome to your account. Here you can manage all of your personal information and orders.",
                "Message on My Account page is incorrect!!!"
        );
    }
}
