package com.automationpracticetest;

import com.automationpractice.pageobjects.LogInPage;
import com.automationpractice.pageobjects.MainPage;
import com.utils.TestListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(TestListener.class)

public class MainPageTest extends BaseTest {

    private MainPage mainPage;

    @Test
    public void openingLogInPageTest() {
        mainPage = new MainPage(driver);
        LogInPage newLogInPage = mainPage
                .open()
                .clickSignInButtonMainPage();
        WebDriverWait wait1 = (new WebDriverWait(driver, 20));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='page-heading']")));
        newLogInPage.jsScrollToBottom(driver); //Javascript executor - scrolls page to the bottom
        newLogInPage.jsScrollToTop(driver); //Javascript executor - scrolls page to the top
        Assert.assertEquals(
                newLogInPage.getHeadingLogInPage(),
                "AUTHENTICATION1",
                "Log In page heading is incorrect!!!"
        );


    }

}
