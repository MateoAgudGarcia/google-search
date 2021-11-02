package com.google.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final long TIMEOUT_IN_SECONDS = 10;
    private static WebDriver webDriver;

    public Waits(WebDriver webDriver) {
        Waits.webDriver = webDriver;
    }

    public void waitVisibleWebElement(By element) {
        WebDriverWait temp = new WebDriverWait(webDriver, Duration.ofSeconds(TIMEOUT_IN_SECONDS));
        temp.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
