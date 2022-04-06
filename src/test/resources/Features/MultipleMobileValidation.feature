Feature: MobileValidation

  Scenario: Title of your scenario
    Given user launch browser with flipkart
    And enter the valid data credentials
    When serach multiple mobile
    And click the mobile
    And validate the mobile details
    Then cheack mobile
    And result

  Scenario: MultiMobileValidation
    Given user launch browser with flipkart
    And enter the valid data credentials
    When serach multiple mobile one diamontinal list
      | iphone | realme | SAMSUNG |
    And click the mobile
    And validate the mobile details
    Then cheack mobile
    And result

  Scenario Outline: MultipleMobileValidation
    Given user launch browser with flipkart
    And enter the valid data credentials
    When serach multiple mobiles "<Phone>"
    And click the mobile
    And validate the mobile details
    Then cheack mobile
    And result

    Examples: 
      | Phone   |
      | SAMSUNG |
      | iPhone  |
      | realme  |
      | OPPO    |
