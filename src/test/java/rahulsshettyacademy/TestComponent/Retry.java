package rahulsshettyacademy.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

//class should implements the method exposed by interface
public class Retry implements IRetryAnalyzer {

	//it ask do i need to re run flaky test
	int count = 0;
	int maxTry = 1;
	
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(count<maxTry) {
			
			count++;
			return true;
		}
		return false;
	}

}
