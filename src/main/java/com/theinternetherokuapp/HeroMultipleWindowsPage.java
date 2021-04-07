package com.theinternetherokuapp;

import com.utils.ReadPropertyFile;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeroMultipleWindowsPage {

    private WebDriver driver;
    private static String heroMultipleWindowsPageTab;
    String baseUrl = ReadPropertyFile.getInstance().getHeroMultipleWindowsPageUrl();

    /*Constructor of current HeroMultipleWindowsPage class*/
    public HeroMultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/windows/new']")
    private WebElement clickHereLink;
    @FindBy(xpath = "//h3[text()='Opening a new window']")
    private WebElement multipleWindowsPageTitle;

    @Step("Open 'Opening a new window' page")
    public HeroMultipleWindowsPage open() {
        driver.get(baseUrl);
        return this;
    }

    @Step("Click on 'Click Here' link")
    public HeroNewWindowPage clickMultipleWindowsLink() {
        heroMultipleWindowsPageTab = driver.getWindowHandle();
        clickHereLink.click();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return new HeroNewWindowPage(driver);
    }

    @Step("Check title on 'Opening a new window' page")
    public String getMultipleWindowsPageTitle() {
        return multipleWindowsPageTitle.getText();
    }

    @Step("Return back to 'Opening a new window' page")
    public HeroMultipleWindowsPage backToPage(){
        driver.switchTo().window(heroMultipleWindowsPageTab);
        return this;
    }

}
