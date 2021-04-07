package com.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {

    private static WebDriver driverSingleton;

    private WebDriverSingleton() {

    }
    /*"else if" implementation*/
//    public static WebDriver getDriver(String browserName) {
//        if (driverSingleton == null) {
//            if (browserName.equals("chrome")) {
//                WebDriverManager.chromedriver().setup();
//                driverSingleton = new ChromeDriver();
//            } else if (browserName.equals("firefox")) {
//                WebDriverManager.firefoxdriver().setup();
//                driverSingleton = new FirefoxDriver();
//            } else {
//                throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }
//        }
//        return driverSingleton;
//    }

    /*"else if" implementation with ENUM*/
//    public static WebDriver getDriver(BrowserNames browserName) {
//        if (driverSingleton == null) {
//            if (browserName == BrowserNames.CHROME) {
//                WebDriverManager.chromedriver().setup();
//                driverSingleton = new ChromeDriver();
//            } else if (browserName == BrowserNames.FIREFOX) {
//                WebDriverManager.firefoxdriver().setup();
//                driverSingleton = new FirefoxDriver();
//            } else {
//                throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }
//        }
//        return driverSingleton;
//    }

    /*"switch" implementation*/
    public static WebDriver getDriver(String browserName) {
        if (driverSingleton == null) {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverSingleton = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverSingleton = new FirefoxDriver();
                    break;
                default:
                    throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
            }
        }
        return driverSingleton;
    }

    //  /*"switch" implementation with ENUM*/
//    public static WebDriver getDriver(BrowserNames browserName) {
//        if (driverSingleton == null) {
//            switch (browserName) {
//                case CHROME:
//                    WebDriverManager.chromedriver().setup();
//                    driverSingleton = new ChromeDriver();
//                    break;
//                case FIREFOX:
//                    WebDriverManager.firefoxdriver().setup();
//                    driverSingleton = new FirefoxDriver();
//                    break;
//                default:
//                    throw new UnsupportedOperationException("Unknown browserName was used - " + browserName);
//            }
//        }
//        return driverSingleton;
//    }

    public static void killDriverInstance() {
        if (driverSingleton != null) {
            driverSingleton.quit();
            driverSingleton = null;
        }
    }

    public static WebDriver returnDriverInstance() {
        if (driverSingleton == null) {
            throw new UnsupportedOperationException("No driver instance running");
        } else {
            return driverSingleton;
        }
    }
}