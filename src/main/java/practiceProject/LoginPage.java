package practiceProject;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.ExcelData;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement emailTxt;
	
	@FindBy(id="continue")
	private WebElement continue_Btn;
	
	@FindBy(id="ap_password")
	private WebElement passwordTxt;
	
	@FindBy(id="signInSubmit")
	private WebElement signInSubmit;
	
	@FindBy(xpath = "//div[@id='invalid-email-alert']/child::div/child::div")
	WebElement loginFailText;
	
	@FindBy(xpath = "//div[@id='auth-error-message-box']/child::div/child::div")
	WebElement AuthFailText;
	
	
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void EnterCorrectEmailPassWordAndClickOnContinue() throws EncryptedDocumentException, IOException
	{
		emailTxt.sendKeys(ExcelData.getExcelData(1, 0));
		continue_Btn.click();
		passwordTxt.sendKeys(ExcelData.getExcelData(1, 1));
		signInSubmit.click();
	}
	public String EnterInCorrectEmailAndClickOnContinue() throws EncryptedDocumentException, IOException, InterruptedException
	{
		emailTxt.sendKeys(ExcelData.getExcelData(2, 0));
		continue_Btn.click();
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(loginFailText));
		String actualText= loginFailText.getText();
		System.out.println(actualText);
		return actualText;
	}
	public String EnterInCorrectPassWordAndClickOnContinue() throws EncryptedDocumentException, IOException, InterruptedException
	{
		emailTxt.sendKeys(ExcelData.getExcelData(3, 0));
		continue_Btn.click();
		passwordTxt.sendKeys(ExcelData.getExcelData(3, 1));
		signInSubmit.click();
		Thread.sleep(15000);
		String actualText= AuthFailText.getText();
		return actualText;
	}
}
