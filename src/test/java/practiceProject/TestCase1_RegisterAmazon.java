package practiceProject;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCase1_RegisterAmazon extends BaseClass
{
	@Test
	public void TC1_RegisterAmazon() throws EncryptedDocumentException, IOException
	{
		Reporter.log("Amazon Registration is done successfully");
	}
	
}
