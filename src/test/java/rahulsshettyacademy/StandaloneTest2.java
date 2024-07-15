package rahulsshettyacademy;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulsshettyacademy.TestComponent.BaseTest;
import rahulsshettyacademy.pageobjects.CartPage;
import rahulsshettyacademy.pageobjects.CheckoutPage;
import rahulsshettyacademy.pageobjects.ConfirmPage;
import rahulsshettyacademy.pageobjects.LandingPage;
import rahulsshettyacademy.pageobjects.ProductCatalog;

   public class StandaloneTest2 extends BaseTest {
	    String prodName = "ZARA COAT 3" ;
		  
	    @Test(dataProvider="getData" , groups = {"Purchase"})
	     public void StandaloneTest(HashMap<String,String> input) throws IOException , InterruptedException
	     {
		   // TODO Auto-generated method stub
		 
	     	
		   //implicit wait . so it will take care any global issue
		
		
		
		  //   LandingPage landingPage = launchApplication(); 
		     
		     ProductCatalog productCatalog = landingPage.loginApplication(input.get("email") , input.get("password"));
		
		     List<WebElement>products = productCatalog.getProductList();
		     productCatalog.addProductToCart(input.get("product"));
		     CartPage cartPage = productCatalog.goToCartPage();
		
		     Boolean match = cartPage.verifyProductDisplay(input.get("product"));
	   
		     //validation will not go in pom
		      Assert.assertTrue(match);
		      CheckoutPage checkoutPage = cartPage.goToCheckOutPage();
		      checkoutPage.selectCountry("india");
		      ConfirmPage confirmPage = checkoutPage.submitOrder();
		
		
		
		
		
		     //Now using actions class lets enter keyword move to element
		
		
             String confirmMsg =  	confirmPage.getConfirmationMsg();
	         Assert.assertTrue(confirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    
	   }
	    
	  /*  @Test(dependsOnMethods= {"StandaloneTest"})
	    public void OrderHistory()
	    {
	    	
	    }*/
          
	    
	   
	    
	    //Extent Report

   
   //dataprovider help us to drive data and pass multiple dataset
       @DataProvider
       public Object[][] getData() throws IOException 
       {
	/*       HashMap<String,String> map = new HashMap<String , String>();
	       map.put("email", "shurbhishukla2904@gmail.com");
	       map.put("password", "Shurbhi@12");
	       map.put("product", "ZARA COAT 3");
	       
	       
	       HashMap<String,String> map1 = new HashMap<String , String>();
	       map1.put("email", "shbhishukla2904@gmail.com");
	       map1.put("password", "Shurbi@12");
	       map1.put("product", "ADIDAS ORIGINAL");
	       
	       
	       //inorder to drive data from multiple dataset
    	   //here object accepts any kind of data type
    	   //{"anshika@gmail.com" , "Iamking@12" , "ZARA COAT 3"},*/
	       
    	//  return new Object[][] {{map} , {map1}};
    	   
    	   List<HashMap<String , String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulsshettyacademy\\data\\PurchaseOrder.json");
    	   return new Object[][] {{data.get(0)},{data.get(1)}};
    	   
    	   
       }  
}