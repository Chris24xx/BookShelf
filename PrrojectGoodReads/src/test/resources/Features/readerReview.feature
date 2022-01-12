Feature: Review Management

  Scenario: as a reader I should be able to create a review
    Given the user clicks on the profile tab.
    When reader selects add review
    When reader scrolls down to new review
    When user enters rating in the rating field
    When user enters review in the review field
    When user submits Review
    Then user gets an alert

  Scenario: as a reader I can get a list of review from a piece of media from the book tab
    Given reader is on the homepage
    When the reader selects the book tab
    When the user selects a title
    Then a list is returned with approved reviews from books tab

  Scenario: as a reader I can get a list of review from a piece of media from the movie tab
    Given reader is on the homepage
    When the reader selects the movie tab
    When the user selects a title from the movie tab
    Then a list is returned with approved reviews from movies tab

  Scenario: as a reader I can get a list of review from a piece of media from the game tab
    Given reader is on the homepage
    When the reader selects the game tab
    When the user selects a title from the games tab
    Then a list is returned with approved reviews from game tab



  Scenario: as a reader I can view my own reviews for a selected media
    Given the user clicks on the profile tab.
    When reader selects a piece of media title
    Then a list is generated for the user
