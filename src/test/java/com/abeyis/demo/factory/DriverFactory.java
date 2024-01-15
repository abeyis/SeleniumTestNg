package com.abeyis.demo.utils;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.util.Objects;

public class Driver {


    private static WebDriver driver;       // static variable: only one copy for all objects

    private Driver() {
    }                 // private constructor : to prevent creating object from this class

    public static WebDriver get() {     // no parameter, getting the browser type from Configuration.Properties

        if (Objects.isNull(driver)) {
            String browser = ConfigurationReader.get("browser");

            switch (browser) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
                    options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                    driver = new ChromeDriver(options);
                }
                case "chrome-headless" -> {     // headless : invisible chrome, your test will be executed.
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless=new");
                    options.addArguments("--start-maximized");
                    driver = new ChromeDriver(options);
                }
                case "firefox" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new FirefoxDriver(options);
                }
                case "firefox-headless" -> {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new FirefoxDriver(options.addArguments("--headless=new"));
                }
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    driver = new EdgeDriver(options);
                }
                case "safari" -> {
                    SafariOptions options = new SafariOptions();
                    driver = new SafariDriver(options);
                }
                default -> throw new IllegalStateException("Unexpected value: " + browser);
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (Objects.nonNull(driver)) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
