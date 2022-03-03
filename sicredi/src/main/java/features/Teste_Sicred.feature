# language: pt
@todos
Funcionalidade: Test Sicred

	@Desafio_01
  Cenario: CT01-Preencher_Formulario
    Dado que eu acesse a url "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
    Quando eu preencher o formulario Add Record e salvar
    Então devo validar a mensagem de sucesso
    
  @Desafio_02
  Cenario: CT02-Buscar_e_Deletar_Formulario
  	Dado que eu acesse novamente a url "https://www.grocerycrud.com/v1.x/demo/my_boss_is_in_a_hurry/bootstrap"
    E eu preencha o formulario Add Record e salve
    E valide a mensagem de sucesso
    E volte a lista de formulários
    Quando eu pesquisar o formulario criado anteriormente e deleta-lo
    Então devo validar a mensagem de que o fomulario foi deletado com sucesso