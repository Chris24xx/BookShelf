Feature: Media management

  Scenario: As a user I want to log in so that I can post and review media that I have experienced.
    Given the user is on the login page.
    When the user enters wherever@yahoo.com in the email field.
    When the user enters password in the password field.
    When the user clicks the login button.
    Then the user is redirected to the home page.


  Scenario Outline: As a user I want to search for media that is not in my collection so that I can add it to my collection.
    Given the user is on the home page.
    When the user clicks the <media> tab.
    Then the user is redirected to the <media> section.

    Examples:
    | media  | media  |
    | books  | books  |
    | movies | movies |
    | games  | games  |


  Scenario: As a user I want to add media to my collection so that I can make reviews on it.
    Given the user clicks on the profile tab.
    When the user clicks on add new media button.
    When the user selects type from the drop down options.
    When the user enters Snow White in the input field.
    When the user enters Walt Disney in the input field.
    When the user enters Children's Adventure in the input field.
    When the user enters Sleeping princess rescued from tower in the textarea field.
    When the user clicks submit new media button.
    Then assert message that new media has been added.



  Scenario: As a moderator I want to review media insertion requests so that I can approve them if they are legitimate.
    Given the moderator is on the moderator page.
    When the moderator clicks the pending media button.
    When the moderator fills in approved media id in the input field.
    When the moderator clicks the approve button.
    Then assert message that media has been approved.


  Scenario: As a moderator I want to review media insertion requests so that I can deny them if they are not legitimate.
    When the moderator clicks the pending media button.
    When the moderator fills in denied media id in the input field.
    When the moderator clicks the deny button.
    Then assert message that media has been denied.


  Scenario: As a moderator I want to view past approved media insertions so that I can view all past decisions.
    When the moderator clicks the pending media button.
    Then assert past media populates.


  Scenario: As a moderator I accidentally enter the wrong media id for approval.
    Given the moderator is on the moderator page.
    When the moderator goes to the pending media tab.
    When the moderator fills in the wrong media id in the input field.
    When the moderator clicks the approve button with the wrong id.
    Then a does not exist message will appear.