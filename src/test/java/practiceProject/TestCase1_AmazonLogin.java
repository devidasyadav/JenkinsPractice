package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase1_AmazonLogin extends BaseClass
{
	@Test
	public void loginToAmazon() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Browser is launched with amazon link");
		HomePage homepage=new HomePage(driver);
		homepage.moveToSignIn(driver);
		Reporter.log("Howover on Accounts and list");
		homepage.clickSignIn();
		Reporter.log("Clicked on signIn ");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.EnterEmailAndClickOnContinue();
		Reporter.log("Clicked on continue after entering email id ");
		loginpage.EnterPasswordAndClickOnSignIn();
		Reporter.log("Clicked on SignIn after entering password");
		Assertion a= new Assertion();
		a.assertEquals(homepage.getUserText(driver), "Hello, Devidas","Text not matching failed!");
		Reporter.log("Usertext: "+homepage.getUserText(driver)+" matched test case passed!");
	}
	
	
	@Test
	public void loginToAmazon_SearchProduct() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Browser is launched with amazon link");
		HomePage homepage=new HomePage(driver);
		homepage.moveToSignIn(driver);
		Reporter.log("Howover on Accounts and list");
		homepage.clickSignIn();
		Reporter.log("Clicked on signIn ");
		LoginPage loginpage= new LoginPage(driver);
		loginpage.EnterEmailAndClickOnContinue();
		Reporter.log("Clicked on continue after entering email id ");
		loginpage.EnterPasswordAndClickOnSignIn();
		Reporter.log("Clicked on SignIn after entering password");
		Assertion a= new Assertion();
		a.assertEquals(homepage.getUserText(driver), "Hello, Devidas","Text not matching failed!");
		boolean listProd=homepage.searchProduct()>50;
		a.assertEquals(listProd, true,"Product not searched failed");
		Reporter.log("test case passed!");
	}
	
}
