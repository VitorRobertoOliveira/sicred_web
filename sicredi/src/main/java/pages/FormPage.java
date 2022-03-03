package pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import maps.FormMaps;

public class FormPage extends BasePage {
	private FormMaps formMaps;
	
	public FormPage(WebDriver driver) {
		super(driver);
		formMaps = new FormMaps(driver);
	}
	
	public void FillsForm() throws Exception	{
		fillsField(formMaps.fieldCustomerName(), "Teste Sicredi");
		fillsField(formMaps.fieldContactLastName(), "Teste");
		fillsField(formMaps.fieldContactFirstName(), "Vitor Roberto Oliveira");
		fillsField(formMaps.fieldPhone(), "51 9999-9999");
		fillsField(formMaps.fieldAddressLine1(), "Av Assis Brasil, 3970");
		fillsField(formMaps.fieldAddressLine2(), "Torre D");
		fillsField(formMaps.fieldCity(), "Porto Alegre");
		fillsField(formMaps.fieldState(), "RS");
		fillsField(formMaps.fieldPostalCode(), "91000-000");
		fillsField(formMaps.fieldCountry(), "Brasil");
		fillsField(formMaps.fieldSalesRepEmployeeNumber(), "Fixter");
		fillsField(formMaps.fieldCreditLimit(), "200");	
	}
	
	public void clickSave() throws Exception {
		click(formMaps.formButtonSave());
	}
	
	public void validatedForm() throws Exception {
		System.out.println("Validando o preenchimento correto do formulário...");
		implicitWait(3000);
		boolean frase = formMaps.fraseSuccess().getText().contains("Your data has been successfully stored into the database. ");
		if (frase) {
			System.out.println("Formulário salvo com sucesso!");
		} else {
			System.out.println("Houve algum problema no preenchimento do formulário!");
		}
		assertTrue(frase);
	}
	
	public void clickBackToList() throws Exception {
		click(formMaps.linkGoBackToList());
	}

}
