Feature: Moderators can make other Users into Moderators

  Scenario: As a Moderator I want to make more Moderators so that I can have a more moderated website
    Given the moderator is on the Moderator Page
    When the moderator clicks the Profile Search button
    When the moderator clicks the Make Moderator button for a User
    Then alert shows up stating you made that user into a moderator