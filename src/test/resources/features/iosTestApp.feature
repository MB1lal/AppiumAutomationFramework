@appium @appiumApp

  Feature: Testing iOS App

    Scenario: App sums numbers correctly
      Given User inputs 10 as "first" number
      And User inputs 24 as "second" number
      When User presses the sum button
      Then The sum should be 34

    Scenario: Alert pops up and closes correctly
      Given User clicks on show alert button
      Then The alert should be displayed
      When User clicks on okay
      Then The popup is closed