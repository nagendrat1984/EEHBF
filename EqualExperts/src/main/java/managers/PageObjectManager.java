package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.HBFSavePage;
import pageObjects.HBFDeletePage;
import pageObjects.HomePage;

public class PageObjectManager {

	private WebDriver driver;
	private HBFSavePage hbfsavepage;
	private HBFDeletePage hbfdeletepage;
	private HomePage homePage;

	public PageObjectManager(WebDriver driver) {

		this.driver = driver;

	}

	public HBFSavePage getHBFSavePage() {

		return (hbfsavepage == null) ? hbfsavepage = new HBFSavePage(driver) : hbfsavepage;
	}
	
	public HBFDeletePage getHBFDeletePage() {

		return (hbfdeletepage == null) ? hbfdeletepage = new HBFDeletePage(driver) : hbfdeletepage;
	}

	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(driver) : homePage;

	}

}
