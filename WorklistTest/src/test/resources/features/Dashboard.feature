#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Prayer Request Dashboard feature
  Use this feature file for all scenarios in the Dashboard page


  Scenario Outline: Checking for the layout of the dashboard page
    Given the user is on the Prayer request dashboard
    When the user inspects the layout of the dashboard for "<Title>", "<Page Heading>" and "<Table Heading>"
    And the data table should have the following headers 
    | ID |
    | Praying for (Who?) |
    | Prayer Request |
    | Date Reported |
    | Date Answered |
    | Status |
    Then the values should be as follows
   	Examples:
   	| Title | Page Heading | Table Heading |
   	| Prayer Request Dashboard |  Prayer List Home Page  |  Prayer Request List |

	Scenario Outline: Check for the number of records in the prayer request table
		Given the user is on the Prayer request dashboard
		When the user checks the Prayer Request List table
		Then the user should see the below data
		| ID | Praying for (Who?) | Prayer Request | Date Reported | Date Answered | Status |
		| 102 | Anoop | Pray for peace of mind	| 04/14/2025	|  | Praying |
		| 103 | Anoop | Pray for a good job for sustenance		| 04/14/2025	|  | Praying |
	
  @dev
	Scenario: Check for the sort behavior in the prayer request table
		Given the user is on the Prayer request dashboard
		When the user checks the Prayer Request List table
		And the user clicks on "<Header>" column
		Then the data table is sorted based on the "<Header>" column
		Examples:
		| Header |
		| ID |
    | Praying for (Who?) |
    | Prayer Request |
    | Date Reported |
    | Date Answered |
    | Status |
#	
#	Scenario: Check for the hyperlinking of the ID values in the data table
#	