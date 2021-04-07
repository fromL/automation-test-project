package com.automationpractice.pageobjects;

import com.automationpractice.BasePage;
import com.utils.ReadPropertyFile;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    private WebDriver driver;
    String baseUrl = ReadPropertyFile.getInstance().getLogInPageUrl();
    Logger log = Logger.getLogger("applicationLogger");

    /*Constructor of current LogInPage class*/
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement logInPageHeading;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailField;
    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    private WebElement signInButtonLogInPage;
    @FindBy(xpath = "//div[@class='alert alert-danger']")
    private WebElement logInPageFailedAuthenticationHeading;

    @Step("Open Login page")
    public LogInPage open() {
        log.debug("Opening login page");
        driver.get(baseUrl);
        return this;
    }
    @Step("Check title on Login page after authentication failure")
    public String getLogInPageFailedAuthenticationHeading() {
        log.debug("Checking title on Login page after authentication failure");
        return logInPageFailedAuthenticationHeading.getText();
    }

    @Step("Check title on Login page")
    public String getHeadingLogInPage() {
        log.debug("Checking title on Login page");
        return logInPageHeading.getText();
    }

    @Step("Enter your email")
    public LogInPage typeEmailLogInPage(String email) {
        log.debug("Entering email");
        emailField.sendKeys(email);
        return this;
    }

    @Step("Enter your password")
    public LogInPage typePasswordLogInPage(String password) {
        log.debug("Entering password");
        passwordField.sendKeys (password);
        return this;
    }

    @Step("Click on 'Sign In' button")
    public LogInPage clickSignInButtonLogInPage() {
        log.debug("Clicking on 'Sign In' button");
        signInButtonLogInPage.click();
        return this;
    }

    @Step("Log in using your credentials")
    public MyAccountPage logInOperation(String email, String password) {
        log.debug("Performing login operation");
        jsHighlightElement(driver, emailField); //Javascript executor - highlights email field
        jsHighlightElement(driver, passwordField); //Javascript executor - highlights password field
        typeEmailLogInPage(email);
        typePasswordLogInPage(password);
        clickSignInButtonLogInPage();
        return new MyAccountPage(driver);
    }
}
