Feature: Virtual Staging API page

  Background:
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | g.cibisoglu92+mobile5@gmail.com |
      | Testzqxwce.2026                 |
    And The user clicks the button.
    Then should display the user avatar

  @Regression
  Scenario: Virtual Staging API page - menu access and CTA redirections
    When the user hovers over the products menu
    Then the products menu lists three product options
    When the user clicks the virtual staging api option
    Then the url ends with "/en/api"
    And the api hero title is "Integrate the Leading AI Virtual Staging API"
    When the user clicks the hero get in touch button
    Then the url ends with "/en/contact"
    When the user returns to the api page
    Then the url ends with "/en/api"
    And the api page is displayed
    When the user scrolls to the api suite section
    And the user clicks learn more on the virtual staging api card
    Then the url ends with "/en/contact"
    When the user returns to the api page
    Then the url ends with "/en/api"
    And the api page is displayed
    When the user clicks learn more on the object detection api card
    Then the url ends with "/en/contact"
    When the user returns to the api page
    Then the url ends with "/en/api"
    And the api page is displayed
    When the user clicks the contact sales button
    Then the url ends with "/en/contact"
    When the user returns to the api page
    Then the url ends with "/en/api"
    And the api page is displayed
    When the user clicks the view pricing button
    Then the url ends with "/en/pricing"
    And the hero title is "Plans & Pricing"
    When the user returns to the api page
    Then the url ends with "/en/api"
    And the api page is displayed
    When the user types "test@ornek.com" in the newsletter field
    Then the newsletter field contains "test@ornek.com"
    And the subscribe button is clickable