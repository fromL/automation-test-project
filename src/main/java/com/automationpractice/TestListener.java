package com.automationpractice;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    Date dateNow = new Date();
    SimpleDateFormat format1 = new SimpleDateFormat("hh_mm_ss");
    String screenshotFileName = format1.format(dateNow) + "_failed_screenshot.jpg";

//    //Implementation using TestContext
//    @Override
//    public void onTestFailure(ITestResult Result1) {
//        System.out.println("Listener for failed tests - Name of the failed test is: " + Result1.getName());
//        WebDriver driver = (WebDriver) Result1.getTestContext().getAttribute("WebDriverContext");
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String screenshotPath = "E:\\mentorship_program\\test_projects\\automation-test-project\\screenshots\\" + screenshotFileName;
//        try {
//            FileHandler.copy(screenshot, new File(screenshotPath));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    //Implementation without using TestContext, "getDriver" method is used instead + Screenshot for Allure
    @Override
    public void onTestFailure(ITestResult Result1) {
        System.out.println("Listener for failed tests - Name of the failed test is: " + Result1.getName());
        File screenshot = ((TakesScreenshot) WebDriverSingleton.getDriver(WebDriverSingleton.BrowserNames.CHROME)).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "E:\\mentorship_program\\test_projects\\automation-test-project\\screenshots\\" + screenshotFileName;
        Path content = Paths.get(screenshot.getAbsolutePath());
        try (InputStream allurescr = Files.newInputStream(content)) {
            FileHandler.copy(screenshot, new File(screenshotPath));
            Allure.addAttachment("allurescreen", allurescr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
