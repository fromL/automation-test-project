package com.theinternetherokuapp;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroNewWindowPage {

    private WebDriver driver;

    /*Constructor of current HeroNewWindow class*/
    public HeroNewWindowPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    private WebElement newWindowTitle;

    @Step("Check title on the page opened in a new tab ('New Window')")
    public String getNewWindowTitle() {
        return newWindowTitle.getText();
    }
}
