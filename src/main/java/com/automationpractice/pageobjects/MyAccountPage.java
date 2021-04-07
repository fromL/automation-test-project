package com.automationpractice.pageobjects;

import com.automationpractice.BasePage;
import com.utils.ReadPropertyFile;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    private WebDriver driver;
    String baseUrl = ReadPropertyFile.getInstance().getMyAccountPageUrl();
    Logger log = Logger.getLogger("applicationLogger");

    /*Constructor of current MyAccountPage class*/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement myAccountWelcomeInfo;

    @Step("Open My Account page")
    public MyAccountPage open() {
        log.debug("Opening My Account page");
        driver.get(baseUrl);
        return this;
    }

    @Step("Check title on Welcome page")
    public String getMyAccountWelcomeInfo() {
        log.debug("Checking title on Login page after successful authentication");
        return myAccountWelcomeInfo.getText();
    }
}
