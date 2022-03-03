package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.FormPage;
import pages.HomePage;

public class Preencher_Formulario {
	private HomePage homePage;
	private FormPage formPage;
	
	public Preencher_Formulario() {
		homePage = new HomePage(BaseTest.driver);
		formPage = new FormPage(BaseTest.driver);
    }
	
	@Dado("que eu acesse a url {string}")
	public void que_eu_acesse_a_url(String string) {
		System.out.println("Acessando url: " + string);
	    homePage.navigateTo(string);
	    }
	
	@Quando("eu preencher o formulario Add Record e salvar")
	public void eu_preencher_o_formulario_Add_Record_e_salvar() throws Exception {
		System.out.println("Selecionando a versão: Bootstrap V4 Theme");
		homePage.selectVersion();
		homePage.clickButtonAddRecord();
		formPage.FillsForm();
		formPage.clickSave();
	}
	
	@Então("devo validar a mensagem de sucesso")
	public void devo_validar_a_mensagem_de_sucesso() throws Exception {
		formPage.validatedForm();
	}
}
