package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps() {
		
		/*Generally in any client project you open the url and have to enter login credentials. 
		Since in Equal experts hotel booking form page there is no login I wrote opening the url in step definition file instead of this method. 
		Ideally you start cucumber file by logging in to an application.*/
			
	}

	@After
	public void AfterSteps() {
		//testContext.getWebDriverManager().closeDriver();
	}

}
