package rahulsshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulsshettyacademy.AbstractComponents.AbstractComponenent;

public class CheckoutPage extends AbstractComponenent {
        WebDriver driver;
	public CheckoutPage(WebDriver driver) { //constructor give life of driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
      
	 @FindBy(css= ".action__submit")
	 WebElement submit;
	 @FindBy(css= "[placeholder= 'Select Country']")
	 WebElement country;
	 @FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	 WebElement selectCountry;
	 By result = By.cssSelector(".ta-results");
	 
	 
	
	 public void selectCountry(String CountryName)
	 {
		 Actions action = new Actions(driver);
		action.sendKeys(country , CountryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
		
	 }
	 
	 public ConfirmPage submitOrder()
	 {
		 submit.click();
		 ConfirmPage confirmPage = new ConfirmPage(driver);
		 return confirmPage;
	 }
}
