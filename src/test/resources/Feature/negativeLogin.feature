Feature: AiStager User Negative Registration And Login

  @Regression_Negative
  Scenario Outline: : The user negative registers on the AiStager site.
    Given The user clicks the Log in button on the homepage.
    When The user clicks the register button on the login page.
    And The user clicks the cookie.
    Then On the registration page,enter a valid email and password.
      | <email>          |
      | <password>       |
      | <passwordRepeat> |
    And The user checks the terms of acceptance box.
    Then The user clicks the Create an account button.
    Then The user should see the warning message.
      | <message> |

    Examples:
      | email          | password         | passwordRepeat    | message             |
      | zxbs@gmal.com  | asdasdfg123215?. | asdasdfg123215?.  | orPressCreatAccount |
      | zxbs@gmail.com | 1234asd          | 1234asd           | passwordCharacters  |
      | zxbs@gmail.com | 1234asd          | 14wsthdfh65645856 | passwordMatch       |
      | zxbs           | asdasdfg123215?. | asdasdfg123215?.  | validEmailAdress    |
      | zxbs@gmail.com | 12345678         | 12345678          | easyPassword        |
      |                | asdasdfg123215?. | asdasdfg123215?.  | validEmailAdress    |
      | zxbs@gmail.com |                  | 1234asd           | passwordCharacters  |


  @Regression_Negative
  Scenario Outline: The user login on the AiStager webSite.
    Given The user clicks the Log in button on the homepage.
    And The user clicks the cookie.
    When On the login page,enter a valid email and password.
      | <email>    |
      | <password> |
    And The user clicks the button.
    Then The user should see the warning message.
      | <message> |

    Examples:
      | email          | password         | message                |
      | zxbs@gmail.com | asdasdfg123215?. | invalidEmailOrPassword |
      | zxbs@gmail.com |                  | passwordCharacters     |
      |                | asdasdfg123215?. | validEmailAdress       |
      | zxbs@gmail.com | 1234a            | passwordCharacters     |
      | zxbs           | asdasdfg123215?. | validEmailAdress       |


  @Regression_Negative
  Scenario Outline: : I forgot my Aistager website password.
    Given The user clicks the Log in button on the homepage.
    When The user clicks forgot password button.
    And The user enters a registered email address.
      | <email> |
    And The user clicks the send email button.
    Then The user should see the warning message.
      | <message> |
    Examples:
      | email | message     |
      |       | pleaseEmail |
      | email | Unable      |
