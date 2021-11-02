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
    private final String URL = "https://www.google.com";
    private final String EXPECTED_SINGER_NAME = "Tupac Shakur";
    private final String EXPECTED_CAREER = "Rapero";
    private final String EXPECTED_ALBUMS = "\u00c1lbumes";
    private final String EXPECTED_MOVIES = "Pel\u00edculas";
    private final String EXPECTED_VIDEOS = "Videos";

    WebDriver webDriver;
    MainPage mainPage;
    ResultPage resultPage;

    @Given("a driver for Google Chrome is configured")
    public void aDriverForGoogleChromeIsConfigured() {
        webDriver = BrowserInitializer.ChromeWebDriver();
    }

    @Given("a driver for Microsoft Edge is configured")
    public void aDriverForMicrosoftEdgeIsConfigured() {
        webDriver = BrowserInitializer.EdgeWebDriver();
    }

    @When("the Google website is opened")
    public void theGoogleWebsiteIsOpened() {
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
        ResultPage resultPage = new ResultPage(webDriver);

        assertThat(resultPage.singerName()).isEqualTo(EXPECTED_SINGER_NAME);
        assertThat(resultPage.personalCareer()).isEqualTo(EXPECTED_CAREER);
        assertThat(resultPage.albums()).isEqualTo(EXPECTED_ALBUMS);
        assertThat(resultPage.films()).isEqualTo(EXPECTED_MOVIES);
        assertThat(resultPage.videos()).isEqualTo(EXPECTED_VIDEOS);
    }
}
