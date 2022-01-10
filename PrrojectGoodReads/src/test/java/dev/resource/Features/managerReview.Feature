Feature:Review Management
  Scenario: as a moderator I should be able to get a list of pending reviews
    Given Moderator is on the moderator home page
    When the Moderator clicks the pending review tab
    Then a list is returned to the moderator


  Scenario: as a moderator I should be able to get a list of approved reviews
    Given Moderator is on the moderator home page
    When the Moderator clicks the pending review tab
    Then a list is returned to the moderator

  Scenario: as a moderator I should be able to approve a review
    Given Moderator is on the moderator home page
    When the Moderator clicks the pending review tab
    When the moderator inputs a number value
    When the moderator clicks the approve button
    Then an a alert appears indicating success

  Scenario: as a moderator I should be able to deny a review
    Given Moderator is on the moderator home page
    When the Moderator clicks the pending review tab
    When the moderator inputs a mediaId into a field
    When the moderator clicks the deny button
    Then an alert will appear