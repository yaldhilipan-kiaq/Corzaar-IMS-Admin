Feature: CORZAAR IMS Mobile Application

  Scenario Outline: Verify admin login with different Inputs
    Given The Corzaar application is launched
    When User Taps the  Sign In button
    And User Switches to Admin Portal
    And User enters Admin Email "<email>"
    And User enters Admin Password "<password>"
    And user taps Continue securely button
    Then User Should be on the "<expected page>"

    Examples:
      | email             | password  | expected page         |
      # |                   |           | remains on admin login page |
      # | admin@corzaar     | Admin@123 | remains on admin login page |
      # | admin@corzaar.com | Admin     | remains on admin login page |
      # | admin@corzaar.com | admin@123 | remains on admin login page |
      # | ADMIN@CORZAAR.COM | ADMIN@123 | remains on admin login page |
      # | admin@corzaar.com | &@%*&&@@% | remains on admin login page |
      # | admin&@$%&*\\     | Admin@123 | remains on admin login page |
      # | 1234567890        | Admin@123 | remains on admin login page |
      # | admin@corzaar.com | 123456    | remains on admin login page |
      | admin@corzaar.com | Admin@123 | navigates to OTP page |

  Scenario Outline: Verify OTP field with Different Inputs
    Given User is on the OTP Verification Page
    When User enters the OTP number "<otp>"
    And User clicks the open admin portal button
    Then User should be on  "<expected page>"

    Examples:
      | otp    | expected page          |
      # |        | remains on OTP page    |
      # | ,-.--, | remains on OTP page    |
      # | 123    | remains on OTP page    |
      | 123456 | Successfully Logged In |
