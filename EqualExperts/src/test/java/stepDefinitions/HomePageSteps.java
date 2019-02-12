package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import pageObjects.HomePage;

/*Generally in all projects we will have login and we will write login as a separate step definition file. 
Navigating to a web page would generally happen in @Before annotation.
Since There is no login in this application form I am using navigating to home page as a separate step definition.*/

public class HomePageSteps {
	
	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		 testContext = context;
		 homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^EE: I navigate to the EE page$")
	public void ee_I_navigate_to_the_EE_page() throws Throwable {

		homePage.navigateTo_HomePage(); 

	}
	

}
