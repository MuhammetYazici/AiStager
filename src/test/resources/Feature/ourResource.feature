Feature: Resources Tests

  Background: Login with valid data
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | testEmail    |
      | testPassword |
    And The user clicks the button.
    Then should display the user avatar

  @Regression @affiliateProgram
  Scenario: Affiliate Program
    When click the resources button on the headers
    When click the affiliate program
    Then verify that the affiliate program page has opened
    When click the join the program button
    When fill the required information and click the sign up button
    Then verify the application received text
    When back to the affiliate program page
    When check Frequently Asked Questions
    When click to join the affiliate program button
    Then verify the join page is opened and turn back to affiliate program page
    When click the contact our team button
    Then verify the contact us page is opened

  @Smoke @Regression @aiVirtualTour
  Scenario: AI Virtual Tour
    When click the resources button on the headers
    When click the AI Virtual Tour button
    Then verify that the Ai Virtual tour page has opened.
    When click the request early access button
    Then verify that the contact us page has opened and get back to AI virtual tour page
    When click the contact support button
    Then verify that the contact us page has opened - AI Virtual Tour

  @Regression @blog
  Scenario: Blog
    When click the resources button on the headers
    When click the blog button
    Then verify that the blog page has opened
    When click to read the Sarahs article
    Then verify that the Sarahs page opened
    When click the back to log button
    Then verify that the blog page
    When click the more articles button
    Then verify the other articles are visible
    When click on the articles one by one.

  @Smoke @Regression @earnPhotos
  Scenario: Earn Photos
    When click the resources button on the headers
    When click the earn photos button
    Then verify that the earn photos page has opened.
    When fill the email box for newsletter and click subscribe button
    Then verify the feed back is visible

  @Regression @ideaCenter
  Scenario: Idea Center
    When click the resources button on the headers
    When click the idea center button
    Then verify that the idea center page has opened
    When click the start staging button
    Then verify that the virtual staging page has opened and get back to idea center page
    Then verify the photos from rooms are hoverable
    When click the view full gallery
    Then verify that the gallery page has opened
    When choose the style of room
    When click the start stagign now button
    Then verify that the virtual staging page has opened
    When back to idea center page
    When click to the get started free button
    Then verify that the virtual staging page has opened and get back to idea center page
    When click to the view pricing button
    Then verify that the pricing page has opened

  @Regression @researchLab
  Scenario: Research Lab
    When click the resources button on the headers
    When click the research lab button
    Then verify that the research lab page has opened
    When click the learn more button
    Then verify that the partners page has opened and get back to the research lab page
    When click the see our work button
    Then verify that the idea center page has opened and turn back to the research lab page
    When click the join research network button
    When click the apply to join button
    Then verify that the contact us page has opened - Research Lab
