Feature: CORZAAR IMS Mobile Application

  Scenario: Verify Admin Login with Invalid EmailID
    Given The Corzaar application is launched
    When User Taps the  Sign In button
    And User Switches to Admin Portal
    And User enters  InvalidEmail ID in the required field
    And User enters  Valid Password in the required field
    And User taps Continue Securely button to verify
    Then User should remain on the Admin Login Page

  Scenario: Verify Admin Login with Invalid Password
    Given User enters Valid Email in the required field
    When User enters  InValid Password in the required field
    And User taps Continue Securely button
    Then User should not able to naviagte to OTP verification page

  Scenario: Verify Admin Login with valid Email and Password
    Given User enters the  Valid Email in the required field
    When User enters the  Valid Password in the required field
    And User taps Continue Securely button for admin access
    Then User should naviagtes to OTP verification Page

  Scenario: Verify Admin Access with InValid OTP
    Given User is on Admin Access Page
    When User enters Invalid OTP in required field
    And User taps Open Admin Portal button
    Then User should remain on the Verify access page

  Scenario: Verify Admin Access with InValid OTP
    Given User enters valid OTP in required field
    When User taps Open Admin Portal button for successful login
    Then User should navigates to Admin Control Centre
