Feature: CORZAAR IMS Mobile Application

  Scenario: Verify Certificates by using Student Name
    Given User is on Admin Control Centre Page
    When User navigates to Certificate module
    And User Search Certificate by student name
    And User Verifies the Revoke Certificate button
    Then Certificate is displayed for the respected student

  Scenario: Verify Certificates by using Invalid Certificate ID
    Given User Search Certificate by Invalid certificate ID
    Then No certificates found for Invalid Certificate ID

  Scenario: Verify Certificates by using Valid Certificate ID
    Given User Search Certificate by certificate ID
    Then Certificate is displayed for the respected ID

  Scenario: Verify Certificates by using Invalid Course Name
    Given User Search Certificate by Invalid course name
    Then No certificates found for Invalid course name

  Scenario: Verify Certificates by using Valid Course Name
    Given User Search Certificate by course name
    Then Certificate is displayed for the respected Course
