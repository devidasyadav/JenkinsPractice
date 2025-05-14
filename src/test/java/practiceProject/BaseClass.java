package practiceProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class BaseClass 
{
	private static ThreadLocal<WebDriver> driverInstance = new ThreadLocal<>();
	WebDriver driver;
	
	public static WebDriver getDriver() 
	{
		return driverInstance.get();
	}
	@BeforeMethod
	@Parameters("browser")
	public void launchBrowser(String browser)
	{

		switch(browser.toLowerCase())
		{
		case "chrome": 
			driver=new ChromeDriver();
			break;
		case "edge": 
			driver=new EdgeDriver();
			break;
		case "firefox": 
			driver=new FirefoxDriver();
			break;

		default: driver=new ChromeDriver();

		}
		driverInstance.set(driver);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.navigate().refresh();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@AfterMethod
	public void quitBrowser() throws InterruptedException
	{
		WebDriver driver=driverInstance.get();
		//Thread.sleep(5000);
		driver.quit();
	}
	
	
}
