Feature: Blog

#=========[ Blog ]=========#

Scenario: User can see blog listing page

	Given user is on "/projects-log" blog page
	Then user should see blog listing page
	And blog test browser will close
	
Scenario: User can see blog entry page

	Given user is on "/projects-log" blog page
	Then user should see blog listing page
	When user clicks first blog title
	Then user should see blog entry page
	And blog test browser will close