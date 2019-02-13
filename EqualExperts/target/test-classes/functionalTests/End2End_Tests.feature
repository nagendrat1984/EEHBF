Feature: Automated End2End Tests
Description: The purpose of this feature is to test End to End of hotel booking form

	
Scenario Outline: Customer navigates to Equal Experts demot hotel booking form website, book the hotel and delete the booking

	Given EE: I navigate to the EE page
	When EE: I enter all the mandatory fields viz "<FirstName>","<LastName>","<Price>","<DepositPaid>","<CheckIn>","<CheckOut>" in the page
	And EE: I click on Save
	Then EE: I should be able to verify that the booking is saved successfully using "<FirstName>"
	And EE: I delete the record created above using "<FirstName>"
	Then EE: I should be able to verify that the booking is deleted successfully using "<FirstName>"

Examples:
			|FirstName	 |LastName      |Price|DepositPaid|CheckIn   |CheckOut  |
			|Nagendra    |Tanguturi     |100  |true       |2019-02-15|2019-02-25|
					