package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase5_SearchProduct extends BaseClass
{
	@Test(priority=2)
	public void TC05_AmazonProductSearch_Shoe() throws EncryptedDocumentException, IOException
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
		boolean listProd=homepage.searchProduct("shoe for men")>50;
		Reporter.log("Product search is done for shoe for men");
		a.assertEquals(listProd, true,"Product not searched: Test failed");
		Reporter.log("test case passed!");
	}
}
