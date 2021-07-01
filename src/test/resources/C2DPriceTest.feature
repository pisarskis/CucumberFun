Feature: C2D price test
  Scenario Outline: Simulating different parcel selections
    Given I start web browser
    And I go to page "https://test-oneclick-pl.easypack24.net/SzybkieNadania/"
    When I click C2D delivery method
    And I click c2d parcel size <size>
    Then C2D price in summary is <price>
    Examples:
    |size|price     |
    |"A" |"14,99 zł"|
    |"B" |"16,49 zł"|
    |"C" |"19,99 zł"|
