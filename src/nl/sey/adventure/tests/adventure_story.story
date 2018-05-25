Scenario: create an adventure 
Given an adventure is created
When I am at the start
Then the location name is 'rivier'

Scenario: from top to w
Given an adventure is created
When I am at location 'top'
Then I can go to 'w'

Scenario: look from berg
Given an adventure is created
When I am at location 'berg'
And I go to 'o'
Then the loction name is 'top'