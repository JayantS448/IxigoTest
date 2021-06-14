
Feature: Validating Place


@ixigo	
Scenario: Fetch flight details
    Given user is on Ixigo website
    When user enter details for journey
    And clicking on search
    Then user is on serched result page
    And validate filters 
    And print the list of airlines costing less than 7000
	
	