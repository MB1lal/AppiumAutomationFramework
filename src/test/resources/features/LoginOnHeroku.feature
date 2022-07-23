@appium @appiumBrowser

Feature: Testing Heroku Web App

  Background: Check for internet connectivity
    Given User has internet connectivity

  Scenario: Login into heroku app
    Given User navigates to heroku
    And User enters username and password
    When User presses login button
    Then User should be logged in
    And User logs out
    And User is logged out