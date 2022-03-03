package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage;

public class FormMaps extends BasePage {
	
	public FormMaps(WebDriver driver) {
        super(driver);
    }
	
	public WebElement fieldCustomerName() {
		WebElement element = driver.findElement(By.id("field-customerName"));
		return element;
	}
	
	public WebElement fieldContactLastName() {
		WebElement element = driver.findElement(By.id("field-contactLastName"));
		return element;
	}
	
	public WebElement fieldContactFirstName() {
		WebElement element = driver.findElement(By.id("field-contactFirstName"));
		return element;
	}
	
	public WebElement fieldPhone() {
		WebElement element = driver.findElement(By.id("field-phone"));
		return element;
	}
	
	public WebElement fieldAddressLine1() {
		WebElement element = driver.findElement(By.id("field-addressLine1"));
		return element;
	}
	
	public WebElement fieldAddressLine2() {
		WebElement element = driver.findElement(By.id("field-addressLine2"));
		return element;
	}
	
	public WebElement fieldCity() {
		WebElement element = driver.findElement(By.id("field-city"));
		return element;
	}
	
	public WebElement fieldState() {
		WebElement element = driver.findElement(By.id("field-state"));
		return element;
	}
	
	public WebElement fieldPostalCode() {
		WebElement element = driver.findElement(By.id("field-postalCode"));
		return element;
	}
	
	public WebElement fieldCountry() {
		WebElement element = driver.findElement(By.id("field-country"));
		return element;
	}
	
	public WebElement fieldSalesRepEmployeeNumber() {
		WebElement element = driver.findElement(By.id("field-salesRepEmployeeNumber"));
		return element;
	}
	
	public WebElement fieldCreditLimit() {
		WebElement element = driver.findElement(By.id("field-creditLimit"));
		return element;
	}
	
	public WebElement fieldDeleted() {
		WebElement element = driver.findElement(By.id("field-deleted"));
		return element;
	}
	
	public WebElement formButtonSave() {
		WebElement element = driver.findElement(By.id("form-button-save"));
		return element;
	}
	
	public WebElement fraseSuccess() {
		WebElement element = driver.findElement(By.xpath("//div[@id='report-success']/p"));
		return element;
	}
	
	public WebElement linkGoBackToList() {
		WebElement element = driver.findElement(By.xpath("//a[@href='/v1.x/demo/my_boss_is_in_a_hurry/bootstrap-v4/']"));
		return element;
	}
}
