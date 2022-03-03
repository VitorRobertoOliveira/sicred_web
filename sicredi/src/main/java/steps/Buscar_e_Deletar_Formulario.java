package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import maps.HomeMaps;
import pages.FormPage;
import pages.HomePage;

public class Buscar_e_Deletar_Formulario {
	private HomePage homePage;
	private FormPage formPage;
	
	public Buscar_e_Deletar_Formulario() {
		homePage = new HomePage(BaseTest.driver);
		formPage = new FormPage(BaseTest.driver);
    }
	
	@Dado("que eu acesse novamente a url {string}")
	public void que_eu_acesse_novamente_a_url(String string) {
		System.out.println("Acessando url: " + string);
	    homePage.navigateTo(string);
	    }
	
	@E("eu preencha o formulario Add Record e salve")
	public void eu_preencha_o_formulario_Add_Record_e_salve() throws Exception {
		System.out.println("Selecionando a versão: Bootstrap V4 Theme");
		homePage.selectVersion();
		homePage.clickButtonAddRecord();
		formPage.FillsForm();
		formPage.clickSave();
	}
	
	@E("valide a mensagem de sucesso")
	public void valide_a_mensagem_de_sucesso() throws Exception {
		formPage.validatedForm();
	}
	
	@E("volte a lista de formulários")
	public void volte_a_lista_de_formulários() throws Exception {
		formPage.clickBackToList();
	}
	
	@Quando("eu pesquisar o formulario criado anteriormente e deleta-lo")
	public void eu_pesquisar_o_formulario_criado_anteriormente_e_deletalo() throws Exception {
		homePage.searchNameAndDelete();
	}
	
	@Então("devo validar a mensagem de que o fomulario foi deletado com sucesso")
	public void devo_validar_a_mensagem_de_que_o_fomulario_foi_deletado_com_sucesso() throws Exception {
		homePage.validatingTtheDeletion();
	}
}
