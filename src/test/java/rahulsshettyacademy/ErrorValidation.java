package rahulsshettyacademy;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulsshettyacademy.TestComponent.BaseTest;
import rahulsshettyacademy.TestComponent.Retry;
import rahulsshettyacademy.pageobjects.CartPage;
import rahulsshettyacademy.pageobjects.CheckoutPage;
import rahulsshettyacademy.pageobjects.ConfirmPage;
import rahulsshettyacademy.pageobjects.LandingPage;
import rahulsshettyacademy.pageobjects.ProductCatalog;

public class ErrorValidation extends BaseTest {
	String prodName = "ZARA COAT 3";
	@Test(groups= {"ErrorHandeling"},retryAnalyzer=Retry.class)
	public void LoginErrorValidationt() throws IOException
	{
		// TODO Auto-generated method stub
		
		String prodName = "ZARA COAT 3";
	
		//implicit wait . so it will take care any global issue
		
		
		
		
		landingPage.loginApplication("shurbhishukla2904@gmail.com", "Shbhi@12");
		Assert.assertEquals("Incorrect email or password,", landingPage.getErrorMessage());
		
	}
	
	public void ProductErrorValidation() throws IOException
	{
		// TODO Auto-generated method stub
		
		String prodName = "ZARA COAT 3";
		ProductCatalog productCatalog = landingPage.loginApplication("surbhishukla2994@gmail.com", "Shurbhi@12");
		
		List<WebElement>products = productCatalog.getProductList();
		productCatalog.addProductToCart(prodName);
		CartPage cartPage = productCatalog.goToCartPage();
		
		Boolean match = cartPage.verifyProductDisplay(prodName);
	   
		//validation will not go in pom
		Assert.assertTrue(match);
		
		
		
		
		
		
		//Now using actions class lets enter keyword move to element
		
		
      
	    
	}


}
