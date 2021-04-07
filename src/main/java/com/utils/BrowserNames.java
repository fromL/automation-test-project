package com.utils;

public enum BrowserNames {
    CHROME("chrome"), FIREFOX("firefox");

    private String browserenum;

    BrowserNames(String browserName1){
        this.browserenum = browserName1;
    }

    public String getBrowserEnum() {
        return browserenum;
    }
}
