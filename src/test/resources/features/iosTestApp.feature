@appium @appiumApp

  Feature: Testing iOS App


      Scenario: App sums numbers correctly
        Given User inputs 10 as "first" number
        And User inputs 24 as "second" number
        When User presses the sum button
        Then The sum should be 34