package com.theinternetherokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroMultipleWindowsPage {

    private WebDriver driver;

    /*Constructor of current HeroMultipleWindowsPage class*/
    public HeroMultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/windows/new']")
    private WebElement clickHereLink;
    @FindBy(xpath = "//h3[text()='Opening a new window']")
    private WebElement multipleWindowsPageTitle;

    public HeroMultipleWindowsPage openMultipleWindowsPage() {
        driver.get("http://the-internet.herokuapp.com/windows");
        return this;
    }

    public HeroNewWindow clickMultipleWindowsLink() {
        clickHereLink.click();
        return new HeroNewWindow(driver);
    }

    public String getMultipleWindowsPageTitle() {
        return multipleWindowsPageTitle.getText();
    }

}
