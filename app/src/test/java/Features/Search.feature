Feature: Search at Google

  Scenario Outline: Run with Google Chrome and Microsoft Edge
    Given a driver for "<Browsers>" is configured
    When the Google website is opened
    Then it recognizes a country is verified

    Given "2pac" is searched at Google
    When the page is fully charged
    Then it evaluates his profile
    And the browser is closed

    Examples:
      | Browsers       |
      | Google Chrome  |
      | Microsoft Edge |
