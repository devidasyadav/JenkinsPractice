package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase2_AmazonLogin_CorrectCreds extends BaseClass
{
	@Test(priority=0)
	public void TC02_loginToAmazon_CorrectCreds() throws EncryptedDocumentException, IOException
	{
		
		Reporter.log("Browser is launched with amazon link");
	
		WebDriver driver=getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.moveToSignIn(driver);
		Reporter.log("Howover on Accounts and list");
		
		homepage.clickSignIn();
		Reporter.log("Clicked on signIn ");
		
		LoginPage loginpage= new LoginPage(driver);
		loginpage.EnterCorrectEmailPassWordAndClickOnContinue();
		Reporter.log("Clicked on SignIn after entering username and password");
	
		Assertion a= new Assertion();
		a.assertEquals(homepage.getUserText(driver), "Hello, Devidas","Text not matching failed!");
		Reporter.log("Usertext: "+homepage.getUserText(driver)+" matched test case passed!");
	}
	
}
