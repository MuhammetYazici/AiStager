Feature: AiStager Pricing Page

  Background:
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | g.cibisoglu92+mobile5@gmail.com |
      | Testzqxwce.2026                 |
    And The user clicks the button.
    Then should display the user avatar

  @Regression
  Scenario: Pricing page plans, checkout redirects and page content
    Given the pricing link is visible
    When the user clicks the pricing link
    Then the url ends with "/en/pricing"
    And the hero title is "Plans & Pricing"
    And the "standard" plan name is "Standard"
    And the "standard" plan price is "$19"
    And the "standard" plan quota is "30 photos per month"
    When the user clicks the "standard" plan button
    Then the modal title is "Upgrade to Standard?"
    When the user confirms the modal
    Then the stripe checkout opens
    And the stripe product name contains "Standard"
    And the stripe amount is "$19.00 per month"
    When the user returns to the pricing page
    Then the url ends with "/en/pricing"
    And the "advanced" plan name is "Advanced"
    And the "advanced" plan price is "$49"
    And the "advanced" plan quota is "90 photos per month"
    And the "advanced" plan badge is "Most Popular"
    When the user clicks the "advanced" plan button
    Then the modal title is "Upgrade to Advanced?"
    When the user confirms the modal
    Then the stripe checkout opens
    And the stripe product name contains "Advanced"
    And the stripe amount is "$49.00 per month"
    When the user returns to the pricing page
    Then the url ends with "/en/pricing"
    And the "premium" plan name is "Premium"
    And the "premium" plan price is "$79"
    And the "premium" plan quota is "180 photos per month"
    When the user clicks the "premium" plan button
    Then the modal title is "Upgrade to Premium?"
    When the user confirms the modal
    Then the stripe checkout opens
    And the stripe product name contains "Premium"
    And the stripe amount is "$79.00 per month"
    When the user returns to the pricing page
    Then the url ends with "/en/pricing"
    And the "enterprise" plan name is "Enterprise"
    And the "enterprise" plan badge is "Custom Solutions"
    When the user clicks the "enterprise" plan button
    Then the contact heading is "Contact Us"
    And the subject field is "Enterprise plan inquiry"
    When the user navigates back
    Then the url ends with "/en/pricing"
    And the top-up title is "10 Photo Credits"
    And the top-up price is "$12"
    And the top-up note is "One-time purchase — non-refundable."
    When the user clicks the top-up button
    Then the stripe checkout opens
    And the stripe product name contains "Top-up 10 Credits"
    And the stripe amount is "$12.00"
    When the user returns to the pricing page
    Then the url ends with "/en/pricing"
    And the comparison title is "Feature Comparison"
    And the comparison header is "Features, Standard, Advanced, Premium, Enterprise"
    And the "Monthly credits" row is "30, 90, 180, Custom"
    And the faq title is "Frequently Asked Questions"
    And the faq questions are listed
    And all faq answers are collapsed
    When the user clicks faq question 1
    Then faq answer 1 is expanded
    When the user clicks faq question 3
    Then faq answer 3 is expanded
    And faq answer 1 is collapsed
    When the user clicks the refund policy link
    Then the url ends with "/en/resources/refund"
    And the support link points to "mailto:support@aistager.ai"
    When the user navigates back
    Then the url ends with "/en/pricing"
    When the user types "test@ornek.com" in the newsletter field
    Then the newsletter field contains "test@ornek.com"
    And the subscribe button is clickable

  @Regression_Negative
  Scenario: Cancelling the upgrade modal does not open checkout
    Given the pricing link is visible
    When the user clicks the pricing link
    Then the url ends with "/en/pricing"
    When the user clicks the "standard" plan button
    Then the modal title is "Upgrade to Standard?"
    When the user cancels the modal
    Then the modal is closed
    And the url ends with "/en/pricing"

  @Regression_Negative
  Scenario: Prices stay in US Dollars on the Turkish site
    Given the pricing link is visible
    When the user clicks the pricing link
    Then the url ends with "/en/pricing"
    When the user switches the language to Turkish
    Then the url ends with "/tr/pricing"
    And the hero title is "Planlar ve Fiyatlandırma"
    And the "standard" plan price is "$19"
    And the "advanced" plan price is "$49"
    And the "premium" plan price is "$79"
    And the top-up price is "$12"
