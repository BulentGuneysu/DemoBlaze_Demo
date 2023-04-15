Feature: Login Test- The user should be able to log in with valid credentials

  Background: Go to the store page
    Given The user is on the login page


  Scenario: Positive Login Test 1
    When The user enters valid credentials
    Then The user verify that Welcome username is displayed


  Scenario: Positive Login Test 2 login with parameter
    When The user enters with "bulent" and "255435" credentials
    Then The user verify that "Welcome bulent" is displayed

  Scenario Outline: Positive Login Test 3 login with scenario outline
    When The user enters with "<username>" and "<password>" credentials
    Then The user verify that "<WelcomeUsername>" is displayed
    Examples:
      | username | password | WelcomeUsername |
      | bulent   | 255435   | Welcome bulent  |
      | bulent   | 255435   | Welcome bulent  |


  Scenario Outline: Positive Login Test 3 login with scenario outline and data table
    When The user enters valid username and password credentials
      | username | <username> |
      | password | <password> |
    Then The user verify that "<WelcomeUsername>" is displayed
    Examples:
      | username | password | WelcomeUsername |
      | bulent   | 255435   | Welcome bulent  |
      | bulent   | 255435   | Welcome bulent  |

  @wip
  Scenario Outline: Negative scenario - The user should NOT be able to log in with invalid credentials
    When The user enters with "<invalidUsername>" and "<invalidPassword>" credentials
    Then The user verify that invalid credential "<message>"
    Examples:
      | invalidUsername | invalidPassword | message              |
      | bulent**        | 255435          | User does not exist. |
      | bulent          | 255435**        | Wrong password. |
      | bulent**        | 255435**        | User does not exist. |
      |                 | 255435          | Please fill out Username and Password. |
      | bulent          |                 | Please fill out Username and Password. |
      |                 |                 | Please fill out Username and Password. |
