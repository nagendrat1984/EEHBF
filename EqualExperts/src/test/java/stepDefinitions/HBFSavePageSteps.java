package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HBFSavePage;
import pageObjects.HBFDeletePage;

public class HBFSavePageSteps {
	
	TestContext testContext;
	HBFSavePage hbfSavePage;
	HBFDeletePage hbfDeletePage;
	 
	 public HBFSavePageSteps(TestContext context) {
		 testContext = context;
		 hbfSavePage = testContext.getPageObjectManager().getHBFSavePage();
		 hbfDeletePage= testContext.getPageObjectManager().getHBFDeletePage();
	 }
	 
	 
	 @When("^EE: I enter all the mandatory fields viz \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" in the page$")
	 public void ee_I_enter_all_the_mandatory_fields_viz_in_the_page(String FirstName, String LastName, String Price, String DepositPaid, String CheckIn, String CheckOut) throws Throwable {
		
		 //hbfSavePage = pageObjectManager.gethbfSavePage();
		 
			hbfSavePage.fill_PersonalDetails(FirstName,LastName,Price,DepositPaid,CheckIn,CheckOut);
			//testContext.scenarioContext.setContext(Context.FIRST_NAME, "Automation");

		}

		@And("^EE: I click on Save$")
		public void ee_I_click_on_Save() throws Throwable {
			//hbfSavePage = new hbfSavePage(driver);
			Thread.sleep(3000);
			hbfSavePage.clickOn_Save(); 
		}

		@Then("^EE: I should be able to see the booking successfully$")
		public void ee_I_should_be_able_to_see_the_booking_successfully() throws Throwable {
			// Write code here that turns the phrase above into concrete actions
			System.out.println("Write code to assert here. Since this is a demo project not writing code here to assert");
		}
		
		
		@When("^EE: I delete the record created above using \"([^\"]*)\"$")
		public void ee_I_delete_the_record_created_above_using(String FirstName) throws Throwable {
			hbfDeletePage.deleteHotelBooking(FirstName);
		}

		@Then("^EE: I should be able to verify that the booking is deleted successfully$")
		public void ee_I_should_be_able_to_verify_that_the_booking_is_deleted_successfully() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			System.out.println("Write code to assert here. Since this is a demo project not writing code here to assert");
		}
		
		

}
