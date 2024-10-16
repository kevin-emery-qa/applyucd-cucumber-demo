Feature: In state first year student should have all campuses available
  Scenario: I can successfully create a new account to apply
    Given The login page has loaded and I see the button to apply
    When I click the button to create an account
    Then I see the form to create a new account
    When I submit the form to create a new account
    Then I land on the first page of the application