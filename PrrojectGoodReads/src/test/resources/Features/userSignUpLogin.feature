Feature: New User Sign Up

  Scenario: As a user I want to sign up so that I can enjoy the benefits of Project The Bookshelf.
    Given the user is on the Login page
    When the user clicks on the sign up button
    When the user inputs their first name in the First Name field
    When the user inputs their last name in the Last Name field
    When the user inputs their email in the Email field
    When the user inputs their password in the Password field
    When the user clicks the Sign Up button
    Then the user has created their account and redirected to the Home page

  Scenario: As a user I'm in the sign up page and want to login.
    Given the user is on the Sign Up page
    When the user clicks on the Already have an account button
    Then the user gets redirected to the Login page

  Scenario:As a user I incorrectly login
    Given the user is on the Login page
    When the user inputs email in the Email field
    When the user inputs a wrong password in the Password field
    When the user clicks the Login button
    Then alert shows up stating Incorrect email or Password

  Scenario: As a user I input blank information when creating my account
    Given the user is on the Sign Up page
    When the user doesn't input something into the information fields
    When the user clicks the Sign Up button
    Then alert shows up stating One of the inputs is empty


  Scenario: As a user I want to log out to keep my account information safe
    Given the user is on the Home page
    When the user clicks the Logout button
    Then get redirected to the Login page