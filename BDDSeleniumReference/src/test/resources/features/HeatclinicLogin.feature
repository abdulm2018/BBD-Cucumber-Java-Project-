Feature: Heatclinic e-commerce Login Functionality

  @debug
  Scenario: 1. Valid user valid password
    Given As a not validated user
    When Browse to the url "http://heatclinic.shiftedtech.com/"
    Then Heatclinic home page should show
    When User click login button
    And Enter "lodi.abdulmohsen@gmail.com" as email address
    And Enter "password" as password
    And Click login
    And Welcome message shows "abdul"

  @functional
  Scenario: 2. Invalid user valid password
    Given As a not validated user
    When Browse to the url "http://heatclinic.shiftedtech.com/"
    Then Heatclinic home page should show
    When User click login button
    And Enter "NotValid_hello2@Gmail.com" as email address
    And Enter "password" as password
    And Click login
    Then Invalid email or password message display

  @functional
  Scenario: 3. Valid user invalid password
    Given As a not validated user
    When Browse to the url "http://heatclinic.shiftedtech.com/"
    Then Heatclinic home page should show
    When User click login button
    And Enter "lodi.abdulmohsen@gmail.com" as email address
    And Enter "good_food" as password
    And Click login
    Then Invalid email or password message display
