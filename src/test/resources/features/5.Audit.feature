Feature: CORZAAR IMS Mobile Application

  Scenario: User Verify Audit
    Given User is on admin Controlcentre 
    When User Click Audit Module
    And User Verifies Coupon is rejected
    Then user Verifies Coupon is approved