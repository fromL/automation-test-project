package com.automationpractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

    private static WebDriver driverSingleton;

    enum BrowserNames {
        CHROME, FIREFOX
    }

    private WebDriverSingleton() {

    }
    /*"else if" implementation*/
//    public static WebDriver getDriver(String browserName) {
//        if (driverSingleton == null) {
//            if (browserName.equals("chrome")) {
//                System.setProperty("webdriver.chrome.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\chromedriver.exe");
//                driverSingleton = new ChromeDriver();
//            } else if (browserName.equals("firefox")) {
//                System.setProperty("webdriver.gecko.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\geckodriver.exe");
//                driverSingleton = new FirefoxDriver();
//            } else {
//                throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }

    /*"else if" implementation with ENUM*/
//    public static WebDriver getDriver(BrowserNames browserName) {
//        if (driverSingleton == null) {
//            if (browserName == BrowserNames.CHROME) {
//                System.setProperty("webdriver.chrome.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\chromedriver.exe");
//                driverSingleton = new ChromeDriver();
//            } else if (browserName == BrowserNames.FIREFOX) {
//                System.setProperty("webdriver.gecko.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\geckodriver.exe");
//                driverSingleton = new FirefoxDriver();
//            } else {
//                throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }

    /*"switch" implementation*/
//    public static WebDriver getDriver(String browserName) {
//        if (driverSingleton == null) {
//            switch (browserName) {
//                case "chrome":
//                    System.setProperty("webdriver.chrome.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\chromedriver.exe");
//                    driverSingleton = new ChromeDriver();
//                    break;
//                case "firefox":
//                    System.setProperty("webdriver.gecko.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\geckodriver.exe");
//                    driverSingleton = new FirefoxDriver();
//                    break;
//                default:
//                    throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }
//        }
//  /*"switch" implementation with ENUM*/
    public static WebDriver getDriver(BrowserNames browserName) {
        if (driverSingleton == null) {
            switch (browserName) {
                case CHROME:
                    System.setProperty("webdriver.chrome.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\chromedriver.exe");
                    driverSingleton = new ChromeDriver();
                    break;
                case FIREFOX:
                    System.setProperty("webdriver.gecko.driver", "E:\\mentorship_program\\test_projects\\automation-test-project\\src\\main\\resources\\drivers\\geckodriver.exe");
                    driverSingleton = new FirefoxDriver();
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
            }
        }

        return driverSingleton;
    }

    public static void killDriverInstance() {
        if (driverSingleton != null) {
            driverSingleton.quit();
            driverSingleton = null;
        }

    }
}
