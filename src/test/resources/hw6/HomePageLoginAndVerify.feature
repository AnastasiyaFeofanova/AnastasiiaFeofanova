Feature: HomePageCheck

  Scenario: HomePage Login and Verify
    Given 1. I open EPAM JDI site
    Then 2. Browser's title must be Home Page
    When 3. I login as user epam with password 1234
    Then 4. User name should be 'PITER CHAILOVSKII'
    And 5. Check interface on Home page, it contains all needed elements.
    And 6. Click on "Service" subcategory in the header and check that drop down contains options
    And 7. Click on Service subcategory in the left section and check that drop down contains options
    When 8. Open through the header menu Service -> Different Elements Page
    Then 9. Check interface on Different elements page, it contains all needed elements
    And 10. Assert that there is Right Section
    And 11. Assert that there is Left Section
    When 12. Select checkboxes
    Then 13. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox
    When 14. Select radio
    Then 15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton
    When 16. Select in dropdown
    Then 17. Assert that for dropdown there is a log row and value is corresponded to the selected value
    When 18. Unselect and assert checkboxes
    Then 19. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox














