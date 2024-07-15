package rahulsshettyacademy.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulsshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
    public LandingPage landingPage; 
	
	public WebDriver initializeDriver() throws IOException
	{
		
		Properties  prop = new Properties(); 
		//to convert file into input stream to that we can send inside prop.load()
		FileInputStream fis = new FileInputStream((System.getProperty("user.dir")+"\\src\\main\\java\\rahulsshettyacademy\\resources\\GlobalData.properties"));
		prop.load(fis);
		String browserName = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		prop.getProperty("browser");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
		return driver;
		
		
		
	}	
	
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
	{
		//reading json to string
		String jsonContent = FileUtils.readFileToString(new File(filePath), 
				StandardCharsets.UTF_8);
	   
		
		
		//convert string to hashmap we will use jackson databind
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String , String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String , String>>>(){
	    
			
			
		});
	        return data;
	}
	
	
	 public String getScreenshot(String testCaseName , WebDriver driver) throws IOException
	    {
	    	//first we have to cast our driver to screenshot so that our driver knows that we have to take a screenshot
	    	TakesScreenshot ts = (TakesScreenshot)driver;
	    	File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
	    	File source = ts.getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(source, file );
	    	return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	    	
	    }
	
	@BeforeMethod
	public LandingPage launchApplication() throws IOException
	{
		
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goTo();
		return landingPage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
