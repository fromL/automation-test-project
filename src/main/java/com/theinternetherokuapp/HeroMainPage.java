package com.theinternetherokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroMainPage {

    private WebDriver driver;

    /*Constructor of current HeroMainPage class*/
    public HeroMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/windows']")
    private WebElement multipleWindowsLink;

    public HeroMainPage openHeroMainPage() {
        driver.get("http://the-internet.herokuapp.com/");
        return this;
    }

    public HeroMultipleWindowsPage clickMultipleWindowsLink() {
        multipleWindowsLink.click();
        return new HeroMultipleWindowsPage(driver);
    }

}
