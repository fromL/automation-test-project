package com.theinternetherokuapptest;

import com.theinternetherokuapp.HeroMultipleWindowsPage;
import com.theinternetherokuapp.HeroNewWindowPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class HeroMultipleWindowsPageTest extends HeroBaseTest {

    private HeroMultipleWindowsPage heroMultipleWindowsPage;

    @Test //Checking several tabs
    public void openingNewTabAndSwitchingBackToFirstTab() {
        heroMultipleWindowsPage = new HeroMultipleWindowsPage(driver);
        heroMultipleWindowsPage.open();
        HeroNewWindowPage newHeroNewWindow = heroMultipleWindowsPage.clickMultipleWindowsLink();
        Assert.assertEquals(
                newHeroNewWindow.getNewWindowTitle(),
                "New Window",
                "Message on New Window page is incorrect!!!"
        );
        heroMultipleWindowsPage.backToPage();
        Assert.assertEquals(
                heroMultipleWindowsPage.getMultipleWindowsPageTitle(),
                "Opening a new window",
                "Message on Multiple Windows page is incorrect!!!"
        );
    }
}
