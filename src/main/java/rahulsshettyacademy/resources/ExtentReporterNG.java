package rahulsshettyacademy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static  ExtentReports getReportObject()
	{
		//ExtentReports , ExtentSparkReporter
				//ExtentSparkReporter  is responsible for creating one html file and do some configuration
				String path = System.getProperty("user.dir")+"\\reports\\index.html";
				
				ExtentSparkReporter reporter = new ExtentSparkReporter(path);
				//below method will help to set report name
				reporter.config().setReportName("Web Automation Result");
				reporter.config().setDocumentTitle("Test Results");
				
				//now we have to create object for extent report . this is our main class while is reposible to drive our reporting excution
			    //ExtentSparkReporter is helper class which is helping to create some configuration and that will finally report to its main class
			     ExtentReports extent = new ExtentReports();
			     extent.attachReporter(reporter);
			     extent.setSystemInfo("Tester", "Surbhi");
			     extent.createTest(path);
			     return extent;
	}

	
	

}
