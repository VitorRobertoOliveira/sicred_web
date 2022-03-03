package maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pages.BasePage;

public class HomeMaps extends BasePage {
	
	public HomeMaps(WebDriver driver) {
        super(driver);
    }
	
	public WebElement combobox() {
		WebElement element = driver.findElement(By.id("switch-version-select"));
		return element;
	}
	
	public WebElement buttonAddRecords() {
		WebElement element = driver.findElement(By.xpath("//div[@class='floatL t5']/a"));
		return element;
	}
	
	public WebElement InputsearchCustomerName() {
		WebElement element = driver.findElement(By.xpath("//input[@placeholder='Search CustomerName']"));
		return element;
	}
	
	public WebElement checkbox() {
		WebElement element = driver.findElement(By.xpath("//input[@class='select-all-none']"));
		return element;
	}
	
	public WebElement buttonDelete() {
		driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.xpath("//div[@class='floatL']/a[@title='Delete']"));
		return element;
	}
	
	public WebElement fraseModal() {
		WebElement element = driver.findElement(By.className("alert-delete-multiple-one"));
		return element;
	}
	
	public WebElement buttonDeleteModal() {
		driver.switchTo().defaultContent();
		WebElement element = driver.findElement(By.xpath("//button[contains(@class,'btn btn-danger delete-multiple')]"));
		return element;
	}
	
	public WebElement fraseAlertFinal() {
		WebElement element = driver.findElement(By.xpath("/html/body/div[3]/span[3]/p"));
		return element;
	}
}
