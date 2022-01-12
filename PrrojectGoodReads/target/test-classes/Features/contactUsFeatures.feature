Feature: Contact us

  Scenario: As a moderator I want to log in so that I can view completed contact us requests.
    Given the moderator is on the login page.
    When the moderator enters wherever@yahoo.com in the email field.
    When the moderator enters password in the password field.
    When the moderator clicks the login button.
    When the moderator is redirected to the moderator home page.
    Then the moderator is able to view the completed contact requests

  Scenario: As a moderator I want view pending contact us requests.
    Given the moderator is on the moderator home page.
    When the moderator views the home page
    Then the moderator is able to view the pending contact requests.

  Scenario: As a moderator I want update a pending contact us requests.
    Given the moderator is on the moderator home page.
    When the moderator enters a pending contact request id
    When the moderator clicks on the update button
    Then the moderator is able to see the pending contact request move to the completed contact request.

  Scenario: As a moderator I want verify I am alerted when an update a pending contact us request is unsuccessful.
    Given the moderator is on the moderator home page.
    When the moderator enters a non existing pending contact request id
    When the moderator clicks on the update button
#    When the update request fails
    Then the moderator is able to see an alert stating your update pending request failed

  Scenario: As a moderator I want verify I am alerted when a delete completed contact us request is unsuccessful.
    Given the moderator is on the moderator home page.
    When the moderator enters a non existing completed contact request id
    Then the moderator is able to see an alert stating your completed requests was unsuccessful

  Scenario: As a moderator I want to delete a completed contact us requests.
    Given the moderator is on the moderator home page.
    When the moderator enters a completed contact request id
    When the moderator clicks on the delete button
    Then the moderator is able to see the completed contact request deleted from the page.

  Scenario: As a user I want to create a contact us request.
    Given the user is on the website home page.
    When the user clicks on contact us button
    When the user enters their email address
    When the user enters their full name
    When the user enters their issue details
    When then the user clicks on the submit button
    Then the user receives a message and is directed to the home page
