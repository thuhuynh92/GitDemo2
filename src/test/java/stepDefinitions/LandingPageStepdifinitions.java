package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOjects.LandingPage;
import utils.TestContextSetup;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LandingPageStepdifinitions {
	//public WebDriver driver;
	//public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;

	public LandingPageStepdifinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws InterruptedException, IOException {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}

	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageProductName + " is extracted from Home page");
	}
	@When ("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
}
