package com.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotTaker {

    static Date dateNow = new Date();
    static SimpleDateFormat format1 = new SimpleDateFormat("hh_mm_ss");
    static String screenshotFileName = format1.format(dateNow) + "_failed_screenshot.jpg";

    public static void takeScreenshot(WebDriver driver){
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/" + screenshotFileName;
        try {
            FileHandler.copy(screenshot, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void takeScreenshotForAllure(){
        File screenshot = ((TakesScreenshot) WebDriverSingleton.returnDriverInstance()).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./screenshots/" + screenshotFileName;
        Path content = Paths.get(screenshot.getAbsolutePath());
        try (InputStream allurescr = Files.newInputStream(content)) {
            FileHandler.copy(screenshot, new File(screenshotPath));
            Allure.addAttachment("allurescreen", allurescr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
