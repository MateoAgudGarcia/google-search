package com.google.search.pom;

import com.google.search.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.google.search.Waits.waitVisibleWebElement;

public class ResultPage {
    private static final int TIMEOUT_IN_SECONDS = 10;
    private final WebDriver WEB_DRIVER;
    private final Waits WAITS;

    private final By FOUND_NAME = new By.ByCssSelector(".qrShPb > span");
    private final By FOUND_CAREER = new By.ByCssSelector(".wwUB2c > span");
    private final By VIDEOS_RECORDED = new By.ByCssSelector("h3.GmE3X");
    private final By ALBUMS_RECORDED = new By.ByCssSelector("#kp-wp-tab-overview > div:nth-child(4) > div > div > div > div > div > div.Ss2Faf.zbA8Me.V88cHc.qLYAZd > div > div.VLkRKc > a");
    private final By FILMS_RECORDED = new By.ByCssSelector("#kp-wp-tab-overview > div:nth-child(3) > div > div > div > div > div > div.Ss2Faf.zbA8Me.V88cHc.qLYAZd > div > div.VLkRKc > a");

    public ResultPage(WebDriver WEB_DRIVER) {
        this.WEB_DRIVER = WEB_DRIVER;
        this.WAITS = new Waits(WEB_DRIVER);
    }

    public String singerName() {
        waitVisibleWebElement(FOUND_NAME);
        return WEB_DRIVER.findElement(FOUND_NAME).getText();
    }

    public String personalCareer() {
        waitVisibleWebElement(FOUND_CAREER);
        return WEB_DRIVER.findElement(FOUND_CAREER).getText();
    }

    public String videos() {
        waitVisibleWebElement(VIDEOS_RECORDED);
        return WEB_DRIVER.findElement(VIDEOS_RECORDED).getText();
    }

    public String albums() {
        waitVisibleWebElement(ALBUMS_RECORDED);
        return WEB_DRIVER.findElement(ALBUMS_RECORDED).getText();
    }

    public String films() {
        waitVisibleWebElement(FILMS_RECORDED);
        return WEB_DRIVER.findElement(FILMS_RECORDED).getText();
    }
}
