package rahulsshettyacademy.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsshettyacademy.AbstractComponents.AbstractComponenent;

public class LandingPage extends AbstractComponenent{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		
         super(driver);
         this.driver = driver;
		//construction of @findby will triggered when we call below method
		PageFactory.initElements(driver, this);
	}
	
	//Step 1 WebElement userEmail = driver.findElement(By.id("userEmail"));
	
	//pAGEfACTORY at runtime will be constructed as step 1 we need not write full step
	
	@FindBy(id="userEmail")
	WebElement userEmail;
     
	@FindBy(id="userPassword")
	WebElement passwordEle;
    
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css ="[class*='flyInOut']")
	WebElement errorMessage;
	
	public ProductCatalog loginApplication(String email , String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}
	
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		
	}

}
