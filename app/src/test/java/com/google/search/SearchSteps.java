package com.google.search;

import com.google.search.pom.MainPage;
import com.google.search.pom.ResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    public static final String MICROSOFT_EDGE = "Microsoft Edge";
    public static final String GOOGLE_CHROME = "Google Chrome";
    WebDriver webDriver;
    MainPage mainPage;
    ResultPage resultPage;

    @Given("a driver for {string} is configured")
    public void aDriverForIsConfigured(String browser) {
        switch (browser) {
            case MICROSOFT_EDGE:
                webDriver = BrowserInitializer.EdgeWebDriver();
                break;
            case GOOGLE_CHROME:
                webDriver = BrowserInitializer.ChromeWebDriver();
                break;
            default:
                System.err.println("Browser has not been selected");
                break;
        }
    }

    @Given("a driver for Google Chrome is configured")
    public void aDriverForGoogleChromeIsConfigured() {

    }

    @Given("a driver for Microsoft Edge is configured")
    public void aDriverForMicrosoftEdgeIsConfigured() {

    }

    @When("the Google website is opened")
    public void theGoogleWebsiteIsOpened() {
        String URL = "https://www.google.com";
        webDriver.get(URL);
        mainPage = new MainPage(webDriver);
    }

    @And("{string} is searched at Google")
    public void isSearchAtGoogle(String query) {
        mainPage.searchAtGoogle(query);
    }

    @Then("the browser is closed")
    public void theBrowserIsClosed() {
        webDriver.close();
    }

    @Then("it recognizes a country is verified")
    public void itGetsCountry() {
        String country = mainPage.nameOfCountry();
        List<String> countries = MainPage.listOfCountries();

        assertThat(countries.contains(country)).isTrue();
    }

    @When("the page is fully charged")
    public void thePageIsFullyCharged() {
        String script = "return document.readyState";
        String expectedResponse = "complete";
        JavascriptExecutor js = (JavascriptExecutor) webDriver;

        String actualResponse = (String) js.executeScript(script);

        assertThat(actualResponse).isEqualTo(expectedResponse);
    }

    @Then("it evaluates his profile")
    public void itEvaluatesHisProfile() {
        resultPage = new ResultPage(webDriver);

        String expectedSingerName = "Tupac Shakur";
        String expectedVideos = "Videos";
        String expectedCareer = "Rapero";
        String expectedAlbums = "\u00c1lbumes";
        String expectedMovies = "Pel\u00edculas";

        assertThat(resultPage.singerName()).isEqualTo(expectedSingerName);
        assertThat(resultPage.personalCareer()).isEqualTo(expectedCareer);
        assertThat(resultPage.albums()).isEqualTo(expectedAlbums);
        assertThat(resultPage.films()).isEqualTo(expectedMovies);
        assertThat(resultPage.videos()).isEqualTo(expectedVideos);
    }
}
