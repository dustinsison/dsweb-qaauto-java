Feature: Homepage

#=========[ Homepage ]=========#

Scenario: User can see the default homepage on dustinsison.com

	Given user is on {page}
	Then user should see {page} header