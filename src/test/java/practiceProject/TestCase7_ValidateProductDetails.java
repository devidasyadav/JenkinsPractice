package practiceProject;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase7_ValidateProductDetails extends BaseClass
{
	@Test(priority=4)
	public void TC7_ValidateProductDetails_OnProductPage() throws EncryptedDocumentException, IOException
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
		homepage.ClickOnProductAfterSearch();
		ProductPage prodPage= new ProductPage(driver);
		List<String> productDetails=prodPage.getProductDetailsAfterClick(driver);
		Reporter.log("Product Details:  "+ productDetails);
		
	}
}
