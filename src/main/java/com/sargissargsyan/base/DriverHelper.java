package com.sargissargsyan.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author sargis on 12/9/23
 * @project test-data-preparation
 */
public class DriverHelper {
    public static DriverHelper get() {
        return new DriverHelper();
    }

    public static WebDriver driver;
    private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    private ChromeOptions options;

    public WebDriver getDriver() {
        if (driverThread.get() == null) {
            driver = WebDriverManager.chromedriver().create();

            driverThread.set(driver);
        }
        return driverThread.get();
    }

    public void quitDriver(WebDriver driver) {
        driver.quit();
        driverThread.remove();
    }
}
