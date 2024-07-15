package rahulsshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulsshettyacademy.AbstractComponents.AbstractComponenent;

public class ConfirmPage extends AbstractComponenent {
	WebDriver driver;
	public ConfirmPage(WebDriver driver) { //constructor give life of driver
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	 @FindBy (css = ".hero-primary")
	 WebElement confirm;
	 
	 public String getConfirmationMsg()
	 {
		 return confirm.getText();
	 }
	 
}
