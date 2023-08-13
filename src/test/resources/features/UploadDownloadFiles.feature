Feature: Test upload and download functionality

  Scenario: Check upload and download files
    Given drivers are initialised
    And go to upload
    When find file upload
    And click file submit
    Then find uploaded files
    And go to download
    Then find downloaded files
    And drivers quited
