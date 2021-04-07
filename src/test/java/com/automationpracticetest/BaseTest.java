package com.automationpracticetest;

import com.utils.BrowserNames;
import com.utils.WebDriverSingleton;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected WebDriver driver; //need to investigate issues with usage of private VS protected modifier in this case
    Logger log = Logger.getLogger("applicationLogger");

    @BeforeMethod //need to rework this method and investigate usage of multiple BeforeMethods (BaseTest VS PageTest)
    @Parameters("browsertestng")
    public void setUp(ITestContext context, @Optional("chrome") String browserParam) {
//        driver = WebDriverSingleton.getDriver(System.getProperty("browser")); //implementation without using ENUM
//        driver = WebDriverSingleton.getDriver(BrowserNames.CHROME); //implementation for ENUM
        driver = WebDriverSingleton.getDriver(browserParam); //implementation for TestNG Parameters
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        context.setAttribute("WebDriverContext", driver);
        log.debug("BeforeMethod from BaseTest was executed");
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.killDriverInstance();
    }

}
