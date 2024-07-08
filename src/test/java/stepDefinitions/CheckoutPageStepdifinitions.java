package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOjects.CheckoutPage;
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

public class CheckoutPageStepdifinitions {
	//public WebDriver driver;
	//public String landingPageProductName;
	public CheckoutPage checkoutPage;
	TestContextSetup testContextSetup;

	public CheckoutPageStepdifinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlanOrder());
	}
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
	}
	
	
}
