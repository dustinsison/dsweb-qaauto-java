Feature: Homepage

#=========[ Homepage ]=========#

Scenario: User can see the default homepage on dustinsison.com

	Given user is on homepage
	Then user should see homepage header
	And homepage test browser will close