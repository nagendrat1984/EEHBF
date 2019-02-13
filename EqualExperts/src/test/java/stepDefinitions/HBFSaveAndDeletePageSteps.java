package stepDefinitions;


import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HBFSavePage;
import pageObjects.HBFDeletePage;

public class HBFSaveAndDeletePageSteps {
	
	TestContext testContext;
	HBFSavePage hbfSavePage;
	HBFDeletePage hbfDeletePage;
	 
	 public HBFSaveAndDeletePageSteps(TestContext context) {
		 testContext = context;
		 hbfSavePage = testContext.getPageObjectManager().getHBFSavePage();
		 hbfDeletePage= testContext.getPageObjectManager().getHBFDeletePage();
	 }
	 
	 
	 @When("^EE: I enter all the mandatory fields viz \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in the page$")
	 public void ee_I_enter_all_the_mandatory_fields_viz_in_the_page(String FirstName, String LastName, String Price, String DepositPaid, String CheckIn, String CheckOut) throws Throwable {
		
			hbfSavePage.fill_PersonalDetails(FirstName,LastName,Price,DepositPaid,CheckIn,CheckOut);

		}

		@And("^EE: I click on Save$")
		public void ee_I_click_on_Save() throws Throwable {
			hbfSavePage.clickOn_Save(); 
		}
		
		@Then("^EE: I should be able to verify that the booking is saved successfully using \"([^\"]*)\"$")
		public void ee_I_should_be_able_to_verify_that_the_booking_is_saved_successfully_using(String FirstName) throws Throwable {
			hbfDeletePage.verifySaveHotelBooking(FirstName);
		}
		
		@When("^EE: I delete the record created above using \"([^\"]*)\"$")
		public void ee_I_delete_the_record_created_above_using(String FirstName) throws Throwable {
			hbfDeletePage.deleteHotelBooking(FirstName);
		}

		@Then("^EE: I should be able to verify that the booking is deleted successfully using \"([^\"]*)\"$")
		public void ee_I_should_be_able_to_verify_that_the_booking_is_deleted_successfully_using(String FirstName) throws Throwable {
			hbfDeletePage.verifyDeletedHotelBooking(FirstName);
		}

}
