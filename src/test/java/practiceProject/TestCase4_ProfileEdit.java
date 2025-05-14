package practiceProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase4_ProfileEdit extends BaseClass
{
	@Test(priority=1)
	public void TC04_EditUserHeightWeight() throws EncryptedDocumentException, IOException, InterruptedException
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
		homepage.EditProfile();
		Reporter.log("User navigated to Your Profile page");
		List<String> expValues=new ArrayList<String>();
		expValues.add("176 cm");
		expValues.add("80 kg");
		
		ProfilePage profilepage= new ProfilePage(driver);
		List<String> HWActualValues = profilepage.EditUserHeightWeight("176", "80");
		Reporter.log("User updated values!"+HWActualValues);
		
		boolean isValuesMatching=HWActualValues.containsAll(expValues);
		a.assertTrue(isValuesMatching,"Condition not matching test failed");
		
		Reporter.log("Profile edit done test case passed!");
	}
}
