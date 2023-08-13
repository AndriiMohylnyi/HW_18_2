Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given driver is initialised
    And user is on login page
    When user enters username and password
    And user clicks on login
    Then user successfully logged in
    And driver quited
