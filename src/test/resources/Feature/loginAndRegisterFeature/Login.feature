Feature: AiStager User Registration And Login

  @Regression
  Scenario: The user registers on the AiStager site.
    Given The user clicks the Log in button on the homepage.
    When The user clicks the register button on the login page.
    And The user clicks the cookie.
    Then On the registration page,enter a valid email and password.
      | yzcmm61+mobile81@gmail.com |
      | fakerPassword              |
      | fakerGeneratePassword      |
    And The user checks the terms of acceptance box.
    Then The user clicks the Create an account button.
    Then The user should see the verify your email message.

  @Regression
  Scenario: The user login on the AiStager webSite.
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | testEmail    |
      | testPassword |
    And The user clicks the button.
    Then should display the user avatar

  @Smoke
  Scenario: I forgot my Aistager website password.
    Given The user clicks the Log in button on the homepage.
    When The user clicks forgot password button.
    And The user enters a registered email address.
      | yzcmm61+mobile81@gmail.com |
    And The user clicks the send email button.
    Then user should see  message


