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
Feature: Dice Auto Apply
  I want to use this template for my feature file

  
  Background: Login to Dice

  @tag2
  Scenario Outline: Apply for the jobs
    Given the user is logged in to Dice
    When filter the jobs as below for the "<job>"
    |criteria|value|
    |posted date | today |
    |type|contract, 3p|
    |employer|recruiter|
    Then apply for all the jobs listed in the list
	Examples:
	|job|
#	|QA Automation|
#	|Java Lead|
	|Project Manager|
