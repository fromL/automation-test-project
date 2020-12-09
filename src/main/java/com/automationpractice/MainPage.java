package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private WebDriver driver;

    /*Constructor of current MainPage class*/
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonMainPage;

    public MainPage openMainPage() {
        driver.get("http://automationpractice.com/index.php");
        return this;
    }

    public LogInPage clickSignInButtonMainPage() {
        signInButtonMainPage.click();
        return new LogInPage(driver);
    }

}
