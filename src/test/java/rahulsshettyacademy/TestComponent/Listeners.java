package rahulsshettyacademy.TestComponent;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import rahulsshettyacademy.resources.ExtentReporterNG;



public class Listeners extends BaseTest implements ITestListener{
	 ExtentTest test;
	 ExtentReports extent  =  ExtentReporterNG.getReportObject();
	 //thread safe .so currcurency is done
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal();
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);//unique thread id
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		extentTest.get().log(Status.PASS, "Test Pass");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	
	{
		((ExtentTest) extentTest.get()).fail(result.getThrowable());//it will print error msg
		
		try {
		driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
				.get(result.getInstance());
		}catch(Exception e1) {
			e1.printStackTrace();
		}
		
		
		String filePath = null;
		//Screenshot , attach it to a report
		try {
			 
			filePath = getScreenshot(result.getMethod().getMethodName() , driver);
			//i cannot use method to get the driver because fields are associated in class level nut not method level
		
			 
		} catch (IOException | IllegalArgumentException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   test.addScreenCaptureFromPath(filePath , result.getMethod().getMethodName());
		
      }

	
	
	
	

	
}