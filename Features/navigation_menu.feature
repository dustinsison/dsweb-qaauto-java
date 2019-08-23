Feature: Navigation Menu

#=========[ Navigation Menu ]=========#

Scenario: User can navigate through the navigation menu

	Given user is on {page}
	When user clicks {navigation_link} button
	Then user should {page} header