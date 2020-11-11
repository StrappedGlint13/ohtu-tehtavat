Feature: As a registered user can log in with valid username/password-combination

    Scenario: user can login with correct password
        Given login is selected
        When correct username "jukka" and password "akkuj" are given
        Then user is logged in

    Scenario: user can not login with incorrect password
        Given login is selected
        When correct username "jukka" and incorrect password "wrong" are given
        Then user is not logged in and error message is given
    
    Scenario: nonexistent user can not login to 
        Given login is selected
        When  nonexistent username "madde" and password "eddam" are given
        Then  system will respond "invalid username or password"
        Then  system will respond "Give your credentials to login"

