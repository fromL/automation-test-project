package com.utils;

import io.qameta.allure.Allure;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

//    Date dateNow = new Date();
//    SimpleDateFormat format1 = new SimpleDateFormat("hh_mm_ss");
//    String screenshotFileName = format1.format(dateNow) + "_failed_screenshot.jpg";

    //Implementation using TestContext
//    @Override
//    public void onTestFailure(ITestResult Result) {
//        Logger log = Logger.getLogger("applicationLogger");
//        log.debug("Listener for failed tests - Name of the failed test is: " + Result.getName());
//        WebDriver driver = (WebDriver) Result1.getTestContext().getAttribute("WebDriverContext");
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotPath = "./screenshots/" + screenshotFileName;
//        try {
//            FileHandler.copy(screenshot, new File(screenshotPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //Implementation without using TestContext, "getDriver" method is used instead + Screenshot for Allure
//    @Override
//    public void onTestFailure(ITestResult Result) {
//        Logger log = Logger.getLogger("applicationLogger");
//        log.debug("Listener for failed tests - Name of the failed test is: " + Result.getName());
//        File screenshot = ((TakesScreenshot) WebDriverSingleton.returnDriverInstance()).getScreenshotAs(OutputType.FILE);
//        String screenshotPath = "./screenshots/" + screenshotFileName;
//        Path content = Paths.get(screenshot.getAbsolutePath());
//        try (InputStream allurescr = Files.newInputStream(content)) {
//            FileHandler.copy(screenshot, new File(screenshotPath));
//            Allure.addAttachment("allurescreen", allurescr);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //Implementation using TestContext + separate method for making screenshots
//    @Override
//    public void onTestFailure(ITestResult Result) {
//        Logger log = Logger.getLogger("applicationLogger");
//        log.debug("Listener for failed tests - Name of the failed test is: " + Result.getName());
//        WebDriver driver = (WebDriver) Result1.getTestContext().getAttribute("WebDriverContext");
//        ScreenshotTaker.takeScreenshot(driver);
//    }

    //Implementation without using TestContext, "getDriver" method is used instead + Screenshot for Allure  + separate method for making screenshots
    @Override
    public void onTestFailure(ITestResult Result) {
        Logger log = Logger.getLogger("applicationLogger");
        log.debug("Listener for failed tests - Name of the failed test is: " + Result.getName());
        ScreenshotTaker.takeScreenshotForAllure();
    }
}
