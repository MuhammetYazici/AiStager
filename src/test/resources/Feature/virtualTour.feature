Feature: Virtual Tour Tests

  Background: Login with valid data
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | testEmail    |
      | testPassword |
    And The user clicks the button.
    Then should display the user avatar

  @Regression
  Scenario: AI Virtual Tour
    When navigate to the AI virtual tour page
    Then verify that the Ai virtual tour page has opened
    When click the Upload From Files tab
    And upload an image for the virtual tour
    Then verify that the image is displayed in the selected images section
    When select "1080p" from the resolution dropdown
    And select "Landscape" from the orientation dropdown
    And open the customise section
    And select "GreatVibes" from the font style dropdown
    And select "Waterfall" from the background audio dropdown
    And enter "selamlar" into the intro text box
    And enter "agent" into the agent name box
    And enter "phone" into the phone box
    And enter "I@mail.com" into the email box
    And upload a profile image
    And upload a logo
    Then verify that the credit cost is displayed
    When click the Create Virtual Tour button


