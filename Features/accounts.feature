Feature: Accounts

#=========[ Accounts ]=========#

Scenario: Subscriber-level user can sign in with valid credentials

	Given user is on {page} page
	When user inputs {username} in username field
	And user inputs {password} in password field
	And user clicks {sign-in} button
	Then user should see {page} header
	
Scenario: User sees error message on log-in page when logging in with invalid credentials

	Given user is on {page} page
	When user inputs {username} in username field
	And user inputs {password} in password field
	And user clicks {sign-in} button
	Then user should see {error} message