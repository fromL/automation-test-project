package com.theinternetherokuapp;

import com.utils.ReadPropertyFile;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroMainPage {

    private WebDriver driver;
    String baseUrl = ReadPropertyFile.getInstance().getHeroMainPageUrl();

    /*Constructor of current HeroMainPage class*/
    public HeroMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement multipleWindowsLink;

    @Step("Open Hero Main page")
    public HeroMainPage open() {
        driver.get(baseUrl);
        return this;
    }

    @Step("Click on 'Multiple Windows' Link")
    public HeroMultipleWindowsPage clickMultipleWindowsLink() {
        multipleWindowsLink.click();
        return new HeroMultipleWindowsPage(driver);
    }
}
