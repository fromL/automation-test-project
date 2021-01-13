package com.theinternetherokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroNewWindow {

    private WebDriver driver;

    /*Constructor of current HeroNewWindow class*/
    public HeroNewWindow(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    private WebElement newWindowTitle;

    public String getNewWindowTitle() {
        return newWindowTitle.getText();
    }
}
