Feature: CORZAAR IMS Mobile Application

  Scenario: User Verify Cashouts
    Given User is on Admin Control Centre
    When User Click Cashout Module
    Then No Cashout message should be displayed
