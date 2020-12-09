package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver; //need to investigate issues with usage of private VS protected modifier in this case

    @BeforeMethod //need to rework this method and investigate usage of multiple BeforeMethods (BaseTest VS PageTest)
    public void setUp() {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
        driver = WebDriverSingleton.getDriver(WebDriverSingleton.BrowserNames.CHROME); //implementation for ENUM
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        System.out.println("BeforeMethod from BaseTest");
    }

}
