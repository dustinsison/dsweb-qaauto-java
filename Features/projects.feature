Feature: Projects

#=========[ Homepage ]=========#

Scenario: User can see project pages

	Given user is on {page}
	When user clicks {navigation_link} button
	And user clicks {navigation_link} button
	Then user should see {page} header