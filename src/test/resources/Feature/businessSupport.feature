Feature: Resources Tests

  Background: Login with valid data
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | testEmail    |
      | testPassword |
    And The user clicks the button.
    Then should display the user avatar

  @Regression @contactUs
  Scenario: Contact Us
    When click the resources button on the headers
    When click the contact us button
    When fill the contact us form and select reason for contact
    When click the privacy box and submit button
    Then verify the message sent text is visible
    When click the quick answer button (view FAQ)
    When click the FAQs one by one
    When click the Contact Support button
    Then verify that the contact us page has opened and turn back to FAQ page
    When click the Schedule a call button
    Then verifiy that the schedule meeting page has opened and turn back to contact us page
    When click the book a time button (SaM)
    Then verify that the Schedule a Meeting page has opened

  @Regression @mlsPartnership
  Scenario: MLS partnership
    When click the resources button on the headers
    When click the MLS partnership button
    Then verify the the MLS partnership has opened
    When click the request MLS integration demo button
    Then verify that the contact us page has opened and get back to the MLS page
    When click the start MLS partnership button
    Then verify that the partners page has opened and get back to the MLS page
    When fill the MLS network form and click submit inquiry button
    Then verify that the inquiry received text is visible and get back to the MLS page
    When click the learn about the partnerships button
    Then verify that the partners page has opened - MLS partnership

  @Regression @partners
  Scenario: Partners
    When click the resources button on the headers
    When click the partners button
    Then verify that the partners page has opened - Partners
    When click the start partnership journey
    When filling in the required information and select partnership type
    When click the submit partnership application button
    Then verify the application received text is visible

  @Smoke @Regression @scheduleMeeting
  Scenario: Schedule a Meeting
    When click the resources button on the headers
    When click the schedule a meeting button
    Then verify that the meeting page has opened

  @Regression @tutorials
  Scenario: Tutorials
    When click the resources button on the headers
    When click the tutorials button
    When click the open staging editor button
    Then verify that the virtual staging page has opened and get back to tutorials page
    When click the join earyl access button
    Then verify the research network page has opened
