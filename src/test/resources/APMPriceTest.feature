Feature: APM price test
  Scenario Outline: Simulating different parcel selections
    Given I start chrome
    And I go to "https://test-oneclick-pl.easypack24.net/SzybkieNadania/"
    And I close cookies popup
    And I close bottom cookies popup
    When I click apm parcel size <size>
    Then APM price in summary is <price>
    Examples:
    |size|price     |
    |"A" |"12,99 zł"|
    |"B" |"13,99 zł"|
    |"C" |"15,49 zł"|
