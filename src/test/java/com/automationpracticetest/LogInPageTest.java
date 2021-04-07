package com.automationpracticetest;

import com.automationpractice.pageobjects.LogInPage;
import com.automationpractice.pageobjects.MyAccountPage;
import com.utils.ReadPropertyFile;
import org.testng.Assert;
import org.testng.annotations.*;

public class LogInPageTest extends BaseTest {

    private LogInPage loginPage;
    String username = ReadPropertyFile.getInstance().getUser();
    String password = ReadPropertyFile.getInstance().getPassword();
    String wrongUsername = ReadPropertyFile.getInstance().getWrongUsername();
    String wrongPassword = ReadPropertyFile.getInstance().getWrongPassword();

    @Test
    public void loginWithInvalidCreds() {
        loginPage = new LogInPage(driver);
        loginPage
                .open()
                .logInOperation(wrongUsername, wrongPassword);
        Assert.assertEquals(
                loginPage.getLogInPageFailedAuthenticationHeading(),
                "There is 1 error\nAuthentication failed.",
                "Error message is incorrect!!!");
    }

    @Test
    public void loginWithValidCreds() {
        loginPage = new LogInPage(driver);
        MyAccountPage newMyAccountPage = loginPage
                .open()
                .logInOperation(username, password);
        Assert.assertEquals(
                newMyAccountPage.getMyAccountWelcomeInfo(),
                "Welcome to your account. Here you can manage all of your personal information and orders.",
                "Message on My Account page is incorrect!!!"
        );
        newMyAccountPage.jsShowSuccessfulLoginPopup(driver); //Javascript executor - showing pop up after successful login
    }
}
