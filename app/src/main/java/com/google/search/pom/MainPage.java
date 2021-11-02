package com.google.search.pom;

import com.google.search.Searches;
import com.google.search.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.google.search.Waits.waitVisibleWebElement;


public class MainPage implements Searches {
    private final WebDriver WEB_DRIVER;
    private final Waits WAITS;

    private final By SEARCH_COMBOBOX = new By.ByName("q");
    private final By SERVER_COUNTRY = new By.ByCssSelector("div.uU7dJb");

    public MainPage(WebDriver WEB_DRIVER) {
        this.WEB_DRIVER = WEB_DRIVER;
        this.WAITS = new Waits(WEB_DRIVER);
    }

    @Override
    public void searchAtGoogle(String queryToSearch) {
        WEB_DRIVER.findElement(SEARCH_COMBOBOX).sendKeys(queryToSearch);
        WEB_DRIVER.findElement(SEARCH_COMBOBOX).submit();
    }

    public String nameOfCountry() {
        waitVisibleWebElement(SERVER_COUNTRY);
        return WEB_DRIVER.findElement(SERVER_COUNTRY).getText();
    }

    public static List<String> listOfCountries() {
        List<String> listCountryCodes = Arrays.asList(Locale.getISOCountries());
        List<String> names = new ArrayList<String>();
        for (String countryCodes : listCountryCodes) {
            Locale localeCountry = new Locale("", countryCodes);
            names.add(localeCountry.getDisplayCountry());
        }
        return names;
    }
}
