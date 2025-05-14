package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase6_SearchBook_Category extends BaseClass
{
	@Test(priority=3)
	public void TC06_SearchInBookCategory() throws EncryptedDocumentException, IOException, InterruptedException
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
		Reporter.log("Usertext: "+homepage.getUserText(driver)+" matched !");
		homepage.searchBookCategory();
		Thread.sleep(2000);
		boolean listProd=homepage.searchProduct("hamlet")>20;
		a.assertEquals(listProd, true,"Product not searched failed");
		
		String catSelect = homepage.getSelectedCatName();
		Reporter.log("Category: "+catSelect+" matched !");
		a.assertEquals(catSelect, "Books","Category not matching");

		Reporter.log("test case passed!");
		
	}
}
