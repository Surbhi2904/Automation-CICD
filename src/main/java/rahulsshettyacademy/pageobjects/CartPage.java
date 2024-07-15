package rahulsshettyacademy.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import rahulsshettyacademy.AbstractComponents.AbstractComponenent;

public class CartPage extends AbstractComponenent {
	
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver)
	{
		super(driver);//sending driver from child to parent inorder to catch the driver we have to create constructor
		this.driver = driver; 
		//construction of @findby will triggered when we call below method
		PageFactory.initElements(driver, this);
	}
	
    

	
	
	
	
	
	public Boolean verifyProductDisplay(String prodName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(prodName));
		
		return match;
		
		
		
	}
	
	public CheckoutPage goToCheckOutPage()
	{    
		checkoutEle.click();
		 CheckoutPage checkoutPage = new CheckoutPage(driver);
		 return checkoutPage;
		
	}

	
	
}  