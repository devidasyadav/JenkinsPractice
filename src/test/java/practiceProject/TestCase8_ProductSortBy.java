package practiceProject;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase8_ProductSortBy extends BaseClass
{
	@Test(priority=5)
	public void TC08_AmazonProdoct_SortByPriceLowToHigh() throws EncryptedDocumentException, IOException, AWTException, InterruptedException
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
		
		ProductPage prodPage=new ProductPage(driver);
		List<String> PricesActualValues=prodPage.ProductPricesLowToHigh();
		Reporter.log("User updated values!"+PricesActualValues);
		Reporter.log("test case passed!");
	}
}
