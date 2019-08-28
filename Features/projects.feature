Feature: Projects

#=========[ Homepage ]=========#

Scenario: User can see project pages

	Given user is on "lavadrop" project page
	Then user should see "LavaDrop" project page header
	And project page test browser will close