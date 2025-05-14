package practiceProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ProfilePage 
{
	WebDriver driver;
	
	@FindBy(xpath = "//div[text()='Height and weight']")
	WebElement heightWeight;

	@FindBy(xpath = "//button[text()='Edit']")
	WebElement editHeightWeight;

	@FindBy(xpath = "(//input[@class='number-input-box'])[1]")
	WebElement heightEdit;

	@FindBy(xpath = "(//input[@class='number-input-box'])[2]")
	WebElement weightEdit;

	@FindBy(xpath = "//div[@class='alert hide-alert']/following-sibling::span/descendant::button")
	WebElement saveHW;

	@FindBy(xpath = "//ul[@class='attribute-list']/dd")
	List<WebElement> HWList;
	
	@FindBy(xpath="//div[@class='profile-name desktop']")
	WebElement ProfileName;

	ProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> EditUserHeightWeight(String Height, String Weight) throws InterruptedException
	{
		heightWeight.click();
		editHeightWeight.click();
		heightEdit.clear();
		heightEdit.sendKeys(Height);
		weightEdit.clear();
		weightEdit.sendKeys(Weight);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(saveHW));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", saveHW);
		//saveHW.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.textToBePresentInElement(ProfileName, "Devidas Yadav"));
		//Thread.sleep(5000);
		List<String> HWValues= new ArrayList<String>();
		for(WebElement e: HWList)
		{
			HWValues.add(e.getText());
		}
		return HWValues;
	}
}
