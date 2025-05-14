package practiceProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopingCartPage
{
	WebDriver driver;
	
	@FindBy(xpath="//h2[normalize-space()='Shopping Cart']")
	WebElement ShoppingCart;
	
	@FindBy(xpath="//h2[normalize-space()='Shopping Cart']")
	WebElement proceedToBuy;
	//input[@name='proceedToRetailCheckout']
	ShopingCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public boolean validateUserIsOnCartPage()
	{
		if(ShoppingCart.isDisplayed() || proceedToBuy.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
