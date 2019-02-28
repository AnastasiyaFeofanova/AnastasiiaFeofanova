Feature: HomePageCheck

  Scenario: Service Page Interface BDD
    Given I open EPAM JDI site
    Then Browser's title must be Home Page
    When I login as user Users.PITER
    Then User name should be Users.PITER.userName
    And Check interface on Home page, it contains all needed elements.
    And Click on Service subcategory in the header and check that drop down contains options
    And Click on Service subcategory in the left section and check that drop down contains options
    When Open through the header menu Service -> Different Elements Page
    Then Check interface on Different elements page, it contains all needed elements
    And Assert that there is Right Section
    And Assert that there is Left Section
    When Select checkboxes WATER and WIND
    Then Assert that there are an individual log row and WATER_ON
    Then Assert that there are an individual log row and WIND_ON
    When Select radiobutton SELEN
    Then Assert that for radiobutton there are a log row and SELEN_ON
    When Select Yellow color in dropdown
    Then Assert that for dropdown there are a log rows and YELLOW_ON
    When Unselect checkboxes WATER and WIND
    Then Assert that there are an individual log row and WATER_OFF
    Then Assert that there are an individual log row and WIND_OFF














