package practiceProject;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot 
{
	public static String getMethodNameWithtime(String MethodName)
	{
		Date d1=new Date();
		String format1_current=d1.toString();
		String month_current=format1_current.substring(4, 7);
		String date_current=format1_current.substring(8, 10);
		String year_current=format1_current.substring(format1_current.length()-4);
		String time_hour=format1_current.substring(11, 13);
		String time_mins=format1_current.substring(14, 16);
		String time_secs=format1_current.substring(17, 19);
		String formatedDate=date_current.concat(month_current).concat(year_current).concat("_").concat(time_hour).concat(" ").concat(time_mins).concat(" ").concat(time_secs);
		
		return MethodName.concat("_").concat(formatedDate);
	}
	
	public static void TakeScreenshotUtility(String methodName,String filePath)
	{
		WebDriver driver= BaseClass.getDriver();
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String filName=getMethodNameWithtime(methodName);
		
		File destination = new File(filePath+filName+".png");
		try
		{
			FileHandler.copy(source, destination);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
