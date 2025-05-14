package practiceProject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

public class ITestListernerLogic implements ITestListener, IAnnotationTransformer 
{
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		ITestListener.super.onTestSuccess(result);
		Reporter.log("Test Case Passed");
		String MethodName = result.getMethod().getMethodName();
		String filePath= "C:\\Users\\Admin\\eclipse-workspace\\seleniumPractice\\MavenTestNG_PracticeProject\\ScreenShots\\PassedTestCases\\";
		Screenshot.TakeScreenshotUtility(MethodName,filePath);
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		ITestListener.super.onTestFailure(result);
		Reporter.log("Test Case Failed");
		String MethodName = result.getMethod().getMethodName();
		String filePath= "C:\\Users\\Admin\\eclipse-workspace\\seleniumPractice\\MavenTestNG_PracticeProject\\ScreenShots\\FailedTestCases\\";
		Screenshot.TakeScreenshotUtility(MethodName,filePath);
	}
	
	@Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
