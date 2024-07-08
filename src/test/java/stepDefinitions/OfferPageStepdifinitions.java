package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOjects.LandingPage;
import pageOjects.OffersPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class OfferPageStepdifinitions {
	
	public String offerPageProductName;
	TestContextSetup testContextSetup;

	public OfferPageStepdifinitions(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}

	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_the_same_shortname_in_offers_page_to_check_if_product_exist(String shortName)
			throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();
	}

public void switchToOffersPage() throws InterruptedException
{
	
	LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	landingPage.selectTopDealsPage();
	testContextSetup.genericUtils.SwichWindowToChild();
	Thread.sleep(3000);
}


	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_Offers_page() {
		Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
	}
}
