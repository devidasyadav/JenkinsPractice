package practiceProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

	@FindBy(xpath = "//div[@role='listitem']")
	List<WebElement> productList;

	@FindBy(xpath = "//option[@selected='selected']")
	WebElement catergoryName;


	@FindBy(xpath="//div[@role='listitem']/descendant::div[@class='s-image-padding']")
	List<WebElement> productImgList;

	@FindBy(xpath="//select[@id='searchDropdownBox']")
	WebElement searchDropdownBox;

	@FindBy(xpath = "//button[text()='Manage Profiles']")
	WebElement manageProfile;

	@FindBy(linkText = "View")
	WebElement view;

	@FindBy(xpath="//h2[@aria-label='Mens Dazzler Sneaker']")
	WebElement PumaShoe;

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
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Online Shopping site in India:"));
		String loginMsg=user.getText();
		return loginMsg;
	}
	public int searchProduct(String strSearch)
	{
		searchProduct.sendKeys(strSearch+Keys.ENTER);
		int ProductCount=productList.size();
		return ProductCount;
	}

	public  void searchBookCategory() throws InterruptedException
	{
		Select select=new Select(searchDropdownBox);
		select.selectByVisibleText("Books");
		Thread.sleep(2000);
		
	}

	public String getSelectedCatName() 
	{
		String selectedCategory=catergoryName.getText();
		return selectedCategory;
	}
	public void EditProfile()
	{
		Actions act = new Actions(driver);
		act.moveToElement(user).build().perform();
		manageProfile.click();
		view.click();
	}

	public void ClickOnProductAfterSearch()
	{
		searchProduct.sendKeys("shoe for men"+Keys.ENTER);
		productImgList.get(5).click();
	}
}
