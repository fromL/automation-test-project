package com.automationpractice.pageobjects;

import com.automationpractice.BasePage;
import com.utils.ReadPropertyFile;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    private WebDriver driver;
    String baseUrl = ReadPropertyFile.getInstance().getMainPageUrl();
    Logger log = Logger.getLogger("applicationLogger");

    /*Constructor of current MainPage class*/
    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='login']")
    private WebElement signInButtonMainPage;

    @Step("Open Main page")
    public MainPage open() {
        log.debug("Opening main page");
        driver.get(baseUrl);
        return this;
    }

    @Step("Click Sign In button on Main page")
    public LogInPage clickSignInButtonMainPage() {
        log.debug("Clicking on 'Sign In' button on Main page");
        signInButtonMainPage.click();
        return new LogInPage(driver);
    }
}
