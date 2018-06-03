Feature: Acessar a página usuarios do sistema Leiloes 

@usrum 
Scenario Outline: Cadastrar novo leilao 
	Given estou na tela cadastro de leilao"<url>"
	When preencho os campos do formulario leilao"<nome>","<valorInicial>","<usuario>","<usado>"
	And clico na opcao 'salvar'
	Then sistema retorna para a pagina anterior "<colNome>","<colDataAbertura>","<colValorInicial>","<colUsuario>","<colUsado>"
	
	Examples: 
		|url							| nome      	     			| valorInicial   | usuario 		 | usado |colNome						 |colDataAbertura|colValorInicial|colUsuario   |colUsado| 													 
		|http://localhost:8180/leiloes	|Conjunto de Mesas de Escritório| 1500.00		 | Lauro Barbosa | sim   |Conjunto de Mesas de Escritório|Data Hoje      |1500.00        |Lauro Barbosa|sim     |
		
		
		
@usrum 
Scenario Outline: Cadastrar novo leilao sem preencher os campos obrigatorios 
	Given estou na tela cadastro de leilao"<url>"
	When preencho os campos do formulario leilao"<nome>","<valorInicial>","<usuario>","<usado>"
	And clico na opcao 'salvar'
	Then sistema exibe uma mensagem de erro no formulario leilao"<validacao>"
	
	Examples: 
		|url							| nome   				| valorInicial   | usuario 		 | usado |validacao		   						| 													 
		|http://localhost:8180/leiloes	|         				| 1500.00		 | Lauro Barbosa | sim   |Nome obrigatorio!						|
		|http://localhost:8180/leiloes	|Lauro Barbosa   	    |       		 | Lauro Barbosa | sim   |Valor inicial deve ser maior que zero!|
		|http://localhost:8180/leiloes	|Lauro Barbosa   	    |      0 		 | Lauro Barbosa | sim   |Valor inicial deve ser maior que zero!|