Feature: create multiple customers for multiple users

  Scenario Outline: 
    Given open "<bn>" browser
    And launch site using "https://dashboard.stripe.com/login"
    When do login using "<uid>" and "<pwd>" credentials
    Then customers tab should be displayed
    When add customers and verify
      | name  | e mail                 | description   |
      | raji  | rajivanam@gmail.com    | hello how r u |
      | aruna | arunavanam28@gmail.com | hi            |
    When do logout
    Then login page should be displayed
    When close site

    Examples: 
      | bn     | uid                         | pwd           |
      | chrome | rajeshwarivanam28@gmail.com | abdulkalam143 |
