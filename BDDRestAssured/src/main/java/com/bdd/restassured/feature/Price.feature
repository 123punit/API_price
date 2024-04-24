Feature: Return the USD rates against multiple currency

Scenario: API call is successful and return valid price
Given Hit the rquest endpoint
When Check API return successful response

Scenario: Check API call for different status message and code
Given Hit the invalid request endpoint with USD1
When Hit the invalid request endpoint with US


Scenario: Check all different scnearios
Given Hit the request endpoint
When Verify USD price against AED and check the prince range between 3.6 and 3.7
Then Check 162 currency pair display in the response 
Then Generate a schema from API response and matches with Json schema

