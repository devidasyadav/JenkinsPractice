package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase3_LoginWithIncorrectCreds extends BaseClass
{
	@Test(priority=-1)
	public void TC03_loginToAmazonWithIncorrectEmail() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("Browser is launched with amazon link");
		WebDriver driver=getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.moveToSignIn(driver);
		Reporter.log("Howover on Accounts and list");
		homepage.clickSignIn();
		Reporter.log("Clicked on signIn ");
		LoginPage loginpage= new LoginPage(driver);
		String expectedText="Invalid email address";
		String actualText=loginpage.EnterInCorrectEmailAndClickOnContinue();
		boolean validateInvalidEmailTxt=actualText.contains(expectedText);
		Reporter.log("Actual text in red:  "+actualText);
		Reporter.log("Clicked on Contiue after entering Incorrect username");
		Assertion a= new Assertion();
		a.assertTrue(validateInvalidEmailTxt, "text not matching"); 
		Reporter.log("test case passed!");
	}
	
	@Test(priority=-2)
	public void TC03_loginToAmazonWithIncorrectPassword() throws EncryptedDocumentException, IOException, InterruptedException
	{
		Reporter.log("Browser is launched with amazon link");
		WebDriver driver=getDriver();
		HomePage homepage=new HomePage(driver);
		homepage.moveToSignIn(driver);
		Reporter.log("Howover on Accounts and list");
		homepage.clickSignIn();
		Reporter.log("Clicked on signIn ");
		LoginPage loginpage= new LoginPage(driver);
		String expectedText="Your password is incorrect";
		String actualText=loginpage.EnterInCorrectPassWordAndClickOnContinue();
		boolean validateInvalidPasswordTxt=actualText.contains(expectedText);
		Reporter.log("Actual text in red:  "+actualText);
		Reporter.log("Clicked on Contiue after entering Incorrect password");
		Assertion a= new Assertion();
		a.assertTrue(validateInvalidPasswordTxt, "text not matching"); 
		Reporter.log("test case passed!");
	}
}
