Feature: Search by keyword

  @smoke @jira-0001
  Scenario Outline: Search zones and validate
    Given user is on SignIn page
    When user enter login details
    And user click on Next button
    Then verify user can able to login
    When user select location '<testdata>'

    Examples: 
      | testdata |
      | Data1    |

  @smoke @jira-0002
  Scenario Outline: Assign zones and validate zone count
    Given user is on SignIn page
    When user enter login details
    And user click on Next button
    Then verify user can able to login
    When user select location '<testdata>'

    Examples: 
      | testdata |
      | Data2     |
