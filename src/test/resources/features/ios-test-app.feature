@appium @appiumApp @iOS

  Feature: Testing iOS App

    Scenario: App sums numbers correctly
      Given User inputs 10 as "first" number
      And User inputs 24 as "second" number
      When User presses sum button
      Then The sum should be 34

    Scenario: Alert pops up and closes correctly
      Given User clicks on show alert button
      Then The alert should be displayed
      When User clicks on okay
      Then The popup is closed

    Scenario: Slider is moved to left correctly
      When User slides the slider to left
      Then The slider percentage < 50%

    Scenario: Slider is moved to right correctly
      When User slides the slider to right
      Then The slider percentage > 50%

      Scenario: Testing gestures
        Given User clicks on test gesture
        When User pans the screen to the right
        Then Map now displays Qatar