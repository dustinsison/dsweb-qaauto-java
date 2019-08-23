Feature: Blog

#=========[ Blog ]=========#

Scenario: User can see blog listing page

	Given user is on {page}
	When user clicks {navigation_link} button
	Then user should see blog listing page
	
Scenario: User can see blog entry page

	Given user is on {page}
	When user clicks {navigation_link} button
	Then user should see blog listing page
	When user clicks blog title
	Then user should see blog entry page