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


    private static final String MICROSOFT_EDGE = "Microsoft Edge";
    private static final String GOOGLE_CHROME = "Google Chrome";
    private static final List<String> OPTIONS_PARAMETERS
            = Arrays.asList("--headless", "--disable-gpu", "--lang=es-co");

    private static WebDriver chromeWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(OPTIONS_PARAMETERS);
        return new ChromeDriver(options);
    }

    private static WebDriver edgeWebDriver() {
        WebDriverManager.edgedriver().setup();
        EdgeOptions options = new EdgeOptions();
        options.addArguments(OPTIONS_PARAMETERS);
        return new EdgeDriver(options);
    }

    public static WebDriver selectWebDriver(String browser){
        switch (browser) {
            case MICROSOFT_EDGE:
                return edgeWebDriver();
            case GOOGLE_CHROME:
                return chromeWebDriver();
            default:
                System.err.println("Browser has not been selected");
                break;
        }
        return null;
    }
}
