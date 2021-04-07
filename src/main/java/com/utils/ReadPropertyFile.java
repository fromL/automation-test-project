package com.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {

    private static ReadPropertyFile instance;
    private static String mainPageUrl;
    private static String loginPageUrl;
    private static String myAccountPageUrl;
    private static String heroMainPageUrl;
    private static String heroMultipleWindowsPageUrl;
    private static String user;
    private static String password;
    private static String wrongUsername;
    private static String wrongPassword;

    public static ReadPropertyFile getInstance() {
        if (instance == null) {
            instance = new ReadPropertyFile();
            instance.loadData();
        }
        return instance;
    }


    private void loadData(){
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("./src/main/resources/configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        mainPageUrl = prop.getProperty("main_page_url");
        loginPageUrl = prop.getProperty("login_page_url");
        myAccountPageUrl = prop.getProperty("my_account_page_url");
        heroMainPageUrl = prop.getProperty("hero_main_page_url");
        heroMultipleWindowsPageUrl = prop.getProperty("hero_multiple_windows_page_url");
        user = prop.getProperty("email");
        password = prop.getProperty("password");
        wrongUsername = prop.getProperty("wrong_email");
        wrongPassword = prop.getProperty("wrong_password");


    }

    public String getMainPageUrl(){
        return mainPageUrl;
    }
    public String getLogInPageUrl(){
        return loginPageUrl;
    }
    public String getMyAccountPageUrl(){
        return myAccountPageUrl;
    }
    public String getHeroMainPageUrl(){
        return heroMainPageUrl;
    }
    public String getHeroMultipleWindowsPageUrl(){
        return heroMultipleWindowsPageUrl;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
    public String getWrongUsername(){
        return wrongUsername;
    }
    public String getWrongPassword(){
        return wrongPassword;
    }
}

