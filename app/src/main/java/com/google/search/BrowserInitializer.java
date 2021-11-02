package com.google.search;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.Arrays;
import java.util.List;

public class BrowserInitializer {

    private static final List<String> OPTIONS_PARAMETERS
            = Arrays.asList("--headless", "--disable-gpu", "--lang=es-co");

    public static WebDriver ChromeWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(OPTIONS_PARAMETERS);
        return new ChromeDriver(options);
    }

    public static WebDriver EdgeWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments(OPTIONS_PARAMETERS);
        return new EdgeDriver(options);
    }
}
