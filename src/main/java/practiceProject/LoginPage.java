package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void EnterEmailAndClickOnContinue() throws EncryptedDocumentException, IOException
	{
		emailTxt.sendKeys(ExcelData.getExcelData(1, 0));
		continue_Btn.click();
	}
	
	public void EnterPasswordAndClickOnSignIn() throws EncryptedDocumentException, IOException
	{
		passwordTxt.sendKeys(ExcelData.getExcelData(1, 1));
		signInSubmit.click();//
	}
}
