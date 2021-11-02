Feature: Search at Google

  Scenario: Run with Chrome
    Given a driver for "Google Chrome" is configured
    When the Google website is opened
    Then it recognizes a country is verified

    Given "2pac" is searched at Google
    When the page is fully charged
    Then it evaluates his profile
    And the browser is closed

  Scenario: Run with Edge
    Given a driver for "Microsoft Edge" is configured
    When the Google website is opened
    Then it recognizes a country is verified

    Given "2pac" is searched at Google
    When the page is fully charged
    Then it evaluates his profile
    And the browser is closed

