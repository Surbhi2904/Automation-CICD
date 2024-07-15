package rahulsshettyacademy.pageobjects;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulsshettyacademy.AbstractComponents.AbstractComponenent;

public class ProductCatalog extends AbstractComponenent {
	
	WebDriver driver;
	public ProductCatalog(WebDriver driver)
	{
		super(driver);//sending driver from child to parent inorder to catch the driver we have to create constructor
		this.driver = driver; 
		//construction of @findby will triggered when we call below method
		PageFactory.initElements(driver, this);
	}
	
    
	//pAGEfACTORY at runtime will be constructed as step 1 we need not write full step
	//List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	
	@FindBy(css = ".mb-3")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	By productsby = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMsg = By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsby);
		return products;
	}
	
	public WebElement getProductByName(String prodName)
	{
		WebElement prod = getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(prodName)).findFirst().orElse(null);
		
		return prod;
	}
	
	public void addProductToCart( String prodName)
	{    
		WebElement prod = getProductByName(prodName);
		prod.findElement(addToCart).click();
		waitForElementToAppear(toastMsg);
		waitForElementToDisappear(spinner);
		
	}

	
	
}  