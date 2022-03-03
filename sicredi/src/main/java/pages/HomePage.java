package pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import maps.HomeMaps;

public class HomePage extends BasePage {
	private HomeMaps homeMaps;
	
	public HomePage(WebDriver driver) {
		super(driver);
		homeMaps = new HomeMaps(driver);
	}
	
	public void selectVersion() throws Exception	{
		selectComboBox(homeMaps.combobox(), "Bootstrap V4 Theme");
	}
	
	public void clickButtonAddRecord() throws Exception {
		click(homeMaps.buttonAddRecords());
	}
	
	public void searchNameAndDelete() throws Exception {
		typeInField(homeMaps.InputsearchCustomerName(), "Teste Sicredi");
		click(homeMaps.checkbox());
		implicitWait(3000);
		click(homeMaps.checkbox());
		click(homeMaps.buttonDelete());
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'item')]")));
		boolean fraseModal = homeMaps.fraseModal().getText().contains("Are you sure that you want to delete this 1 item?");
		if (fraseModal) {
			System.out.println("Formulário deletado com sucesso!");
			click(homeMaps.buttonDeleteModal());
		} else {
			System.out.println("Houve algum problema ao confirmar a deleção do formulário!");
		}
		assertTrue(fraseModal);
	}
	
	public void validatingTtheDeletion() throws Exception {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/span[3]/p")));		
		boolean fraseAlert = homeMaps.fraseAlertFinal().getText().contains("Your data has been successfully deleted from the database.");
		if (fraseAlert) {
			String frase = homeMaps.fraseAlertFinal().getText();
			System.out.println("A mensagem de sucesso [ " + frase + " ] foi apresentada na tela conforme esperado!");			
		} else {
			System.out.println("Houve algum problema ao validar a exclusão do formulário!");
		}
		assertTrue(fraseAlert);
	}

}
