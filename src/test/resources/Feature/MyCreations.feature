Feature: My Creations

  Background:
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | g.cibisoglu92+mobile5@gmail.com |
      | Testzqxwce.2026                 |
    And The user clicks the button.
    Then should display the user avatar

  @Regression
  Scenario: My Creations - viewing photo and video generations
    When the user hovers over the my creations menu
    Then the my creations menu lists two options
    When the user clicks the my photos option
    Then the url ends with "/en/my-photos"
    And the my photos heading is "My Photos"
    And the photo grid lists at least one card
    And every photo card shows an image, a title and a date
    And the photo cards are ordered by date, newest first
    When the user opens the first photo card
    Then the photo modal is open
    And the preview image is displayed
    And the preview caption shows a date and a title
    And the download, continue editing and regenerate buttons are clickable
    When the user selects the "Original" variant
    Then the preview image changes
    When the credit balance is recorded
    Then the credit balance is numeric
    When the user clicks the regenerate button
    Then the generate new design button is displayed
    When the user starts the regeneration
    Then the regeneration completes
    And the variant count increased by one
    And the new variant is first in the strip
    And the preview date is today
    And the credit balance is unchanged
    When the user clicks the download button
    Then a file starting with "aistager-virtual-staging-" and ending with ".jpg" is downloaded
    When the user closes the photo modal
    Then the photo modal is closed
    And the photo grid lists at least one card
    And the regenerated card is first in the grid
    And the first photo card date is today
    And the first photo card result count increased by one
    When the user reopens the first photo card
    Then the photo modal is open
    When the user clicks the continue editing button
    Then the url ends with "/en/virtual-staging"
    When the user returns to the my photos page
    Then the url ends with "/en/my-photos"
    And the my photos heading is "My Photos"
    When the user hovers over the my creations menu
    Then the my creations menu lists two options
    When the user clicks the my videos option
    Then the url ends with "/en/my-videos"
    And the my videos heading is "My Videos"
    And the video grid lists at least one card
    And every video card shows an image, a title, a date and the credits used
    And the video cards are ordered by date, newest first
    When the user opens the first video card
    Then the url contains "/en/virtual-tour/"
    And the virtual tour heading is "Your Virtual Tour is Ready"
    And a video player is displayed
    When the user returns to the my videos page
    Then the url ends with "/en/my-videos"
    And the my videos heading is "My Videos"

  @Regression_Negative
  Scenario: The preview can be closed without the X button
    When the user hovers over the my creations menu
    And the user clicks the my photos option
    Then the url ends with "/en/my-photos"
    When the user opens the first photo card
    Then the photo modal is open
    When the user presses escape
    Then the photo modal is closed
    When the user reopens the first photo card
    Then the photo modal is open
    When the user clicks outside the modal
    Then the photo modal is closed
    And the photo grid lists at least one card

  @Regression_Negative
  Scenario: Leaving the regeneration panel does not create a new design
    When the user hovers over the my creations menu
    And the user clicks the my photos option
    Then the url ends with "/en/my-photos"
    When the user opens the first photo card
    And the variant count is recorded
    And the user clicks the regenerate button
    Then the generate new design button is displayed
    When the user closes the photo modal
    Then the photo modal is closed
    When the user reopens the first photo card
    Then the variant count is unchanged
    And the generate new design button is not displayed
