package com.theinternetherokuapp;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeroMultipleWindowsPageTest extends HeroBaseTest {

    private WebDriver driver;
    private HeroMultipleWindowsPage heroMultipleWindowsPage;

    @BeforeMethod
    public void setUp2() {
//        driver = HeroWebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = HeroWebDriverSingleton.getDriver(HeroWebDriverSingleton.BrowserNames.CHROME); //implementation for ENUM
        heroMultipleWindowsPage = new HeroMultipleWindowsPage(driver);
        System.out.println("BeforeMethod from HeroMultipleWindowsPageTest");
    }

    @AfterMethod
    public void tearDown() {
        HeroWebDriverSingleton.killDriverInstance();
    }

    @Test //Checking several tabs
    public void openingNewTabAndSwitchingBackToFirstTab() {
        heroMultipleWindowsPage.openMultipleWindowsPage();
        String heroMultipleWindowsPageTab = driver.getWindowHandle();
        HeroNewWindow newHeroNewWindow = heroMultipleWindowsPage.clickMultipleWindowsLink();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        String newHeroWindowTitle = newHeroNewWindow.getNewWindowTitle();
        Assert.assertEquals(
                newHeroWindowTitle,
                "New Window",
                "Message on New Window page is incorrect!!!"
        );
        driver.switchTo().window(heroMultipleWindowsPageTab);
        String newMultipleWindowsTitle = heroMultipleWindowsPage.getMultipleWindowsPageTitle();
        Assert.assertEquals(
                newMultipleWindowsTitle,
                "Opening a new window",
                "Message on Multiple Windows page is incorrect!!!"
        );
    }
}