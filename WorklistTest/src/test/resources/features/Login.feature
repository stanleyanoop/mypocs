Feature: Login Feature

    Scenario: Successful login
        Given the user is on the login page
        When the user enter valid credentials "<username>" and "<password>"
        And the user click the login button
        Then the user should be redirected to the dashboard
    Examples:
        | username | password |
        | test    | testPwd    |
     #   | user2    | pass2    |
  
    Scenario: Unsuccessful login
        Given the user is on the login page
        When the user enter invalid credentials "<username>" and "<password>"
        And the user click the login button
        Then the user should see an error message
    Examples:
        | username | password |
        | wrongUser | wrongPwd |
        |	| testPwd |
        |test | |
    