package practiceProject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage 
{
	WebDriver driver;

	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	private WebElement SortByDropDown;

	@FindBy (xpath="//span[@class='a-price']/child::span/span[@class='a-price-whole']")
	List<WebElement> ListProductPrice;
	
	@FindBy(xpath="//span[@id='productTitle']")
	 WebElement productTitle;
	
	@FindBy(xpath="(//a[contains(@class,'declarative mvt')]/child::span)[1]")
	 WebElement reviewScore;
	
	@FindBy(xpath="(//span[@id='acrCustomerReviewText'])[1]")
	 WebElement totalReviews;
	
	@FindBy(xpath="(//span[@class='a-price-whole'])[1]")
	 WebElement productPrice;
	
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	 WebElement addToCart;
	
	@FindBy(xpath="//h1[normalize-space()='Added to cart']")
	 WebElement addedToCartText;
	
	@FindBy(xpath="//span[@id='sw-gtc']//a[normalize-space()='Go to Cart']")
	 WebElement GoToCart;
	
	ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> ProductPricesLowToHigh() throws AWTException, InterruptedException
	{
		SortByDropDown.click();
		Thread.sleep(2000);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(2000);
		
		List<String> ProductPrices= new ArrayList<String>();
		for(WebElement e: ListProductPrice)
		{
			ProductPrices.add(e.getText());
		}
		return ProductPrices;
	}
	
	public List<String> getProductDetailsAfterClick(WebDriver driver)
	{
		Set<String> windows= driver.getWindowHandles();
		for(String window: windows)
		{
			driver.switchTo().window(window);
			String pageTitle=driver.getTitle();
			if(!(pageTitle.equals("Amazon.in : shoe for men")))
			{
				continue;
			}
		
			
		}
		List<String> productDetails= new ArrayList<String>();
		productDetails.add(productTitle.getText());
		productDetails.add(reviewScore.getText());
		productDetails.add(totalReviews.getText());
		productDetails.add(productPrice.getText());
		
		return productDetails;	
	}
	
	public String addToCart()
	{
		addToCart.click();
		
		return addedToCartText.getText();
	}
	
	public void GotoCart()
	{
		GoToCart.click();
		
		//h2[normalize-space()='Shopping Cart']
	}
}
