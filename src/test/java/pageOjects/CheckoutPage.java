package pageOjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
public WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By cartBag = By.cssSelector("img[alt=\"Cart\"]");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	public void CheckoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
		System.out.println("hello 1");
		System.out.println("hello 2");
		System.out.println("hello 3");
	}
	public boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	public boolean VerifyPlanOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
	
}
