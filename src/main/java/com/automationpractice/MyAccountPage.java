package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends BasePage {

    private WebDriver driver;

    /*Constructor of current MyAccountPage class*/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement myAccountWelcomeInfo;

    public MyAccountPage openMyAccountPage() {
        driver.get("http://automationpractice.com/index.php?controller=my-account");
        return this;
    }

    public String getMyAccountWelcomeInfo() {
        return myAccountWelcomeInfo.getText();
    }
}
