Feature: Test Google search functionality

Rule: The user can search for anything on the websites using Google as a search engine.

Scenario: As a user I enter a search criteria in Google
Given I am on the Google search page
When I enter a search criteria
And click on the search button
Then the results match the criteria