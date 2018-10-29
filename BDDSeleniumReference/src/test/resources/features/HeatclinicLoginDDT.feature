Feature: Heatclinic e-commerce Login Functionality

  Background:
    Given As a not validated user
    When Browse to the url "http://heatclinic.shiftedtech.com/"
    Then Heatclinic home page should show

  Scenario: Invalid user valid password
    When User click login button
    And Enter "NotValid_paxqa2@Gmail.com" as email address
    And Enter "paxotech" as password
    And Click login
    Then Invalid email or password message display

  @DD
  Scenario Outline: Valid user valid password
    When User click login button
    And Enter "<emailaddress>" as email address
    And Enter "<password1>" as password
    And Click login
    And Welcome message shows "<username>"
    Examples:
      |emailaddress               |password1        |username|
      |lodi.abdulmohsen@gmail.com |password        |abdul   |
      |shagor77@gmail.com         |shagor          |ben     |