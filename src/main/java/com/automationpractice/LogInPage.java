package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends BasePage {

    private WebDriver driver;

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

    public LogInPage openLogInPage() {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        return this;
    }

    public String getLogInPageFailedAuthenticationHeading() {
        return logInPageFailedAuthenticationHeading.getText();
    }

    public String getHeadingLogInPage() {
        return logInPageHeading.getText();
    }

    public LogInPage typeEmailLogInPage(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LogInPage typePasswordLogInPage(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public MyAccountPage logInOperation(String email1, String password1) {
        this.typeEmailLogInPage(email1);
        this.typePasswordLogInPage(password1);
        signInButtonLogInPage.click();
        return new MyAccountPage(driver);
    }

}
