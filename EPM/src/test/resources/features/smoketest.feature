Feature: Smoke Test
  As a user
  I need to see the web elements
  to be able to navigate until profile page and complete profile update process

  @tag1
  Scenario: Visibility of profile option
    Given user has been on the main page
    And he has logged in
      | filter  |
      | 8487222 |
    Then he should see the profile option


  Scenario: Visibility of save changes button
    Given user has been on the main page
    And he has logged in
      | filter  |
      | 8487222 |
    And he has navigate to profile update page
    Then he should see save changes button