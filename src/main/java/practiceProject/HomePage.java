package practiceProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage 
{
	WebDriver driver;
	@FindBy(xpath="//span[text()='Hello, sign in']")
	WebElement SignIn_accounts;
	
	@FindBy(xpath="//span[text()='Sign in']")
	WebElement SignIn_Btn;
	
	@FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
	WebElement user;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement searchProduct;
	
	@FindBy(xpath = "//div[@class='a-section a-spacing-base']")
	List<WebElement> productList;
	
	HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void moveToSignIn(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.moveToElement(SignIn_accounts).build().perform();
	}
	
	public void clickSignIn()
	{
		SignIn_Btn.click();
	}
	
	public String getUserText(WebDriver driver)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(4));
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in/?ref_=nav_signin"));
		String loginMsg=user.getText();
		return loginMsg;
	}
	public int searchProduct()
	{
		searchProduct.sendKeys("shoe for men"+Keys.ENTER);
		int ProductCount=productList.size();
		return ProductCount;
	}
}
