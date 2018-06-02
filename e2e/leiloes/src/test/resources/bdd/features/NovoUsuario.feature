Feature: Acessar a página usuarios do sistema Leiloes 

@usrum 
Scenario Outline: Cadastrar novo usuario 
	Given estou na tela cadastro de usuario"<url>"
	When preencho os campos do formulario"<nome>","<email>"
	And clico no botao 'salvar' 
	Then sistema retorna para a pagina anterior "<colNome>","<colEmail>"
	
	Examples: 
		|url							| nome      	     | email 	     			| colNome 		| colEmail 				|												 
		|http://localhost:8180/usuarios	| Lauro Barbosa      | lauro.mrocha@gmail.com   | Lauro Barbosa | lauro.mrocha@gmail.com|
		
		
		
@usrum 
Scenario Outline: Cadastrar novo usuario sem preencher os campos obrigatórios 
	Given estou na tela cadastro de usuario"<url>"
	When preencho os campos do formulario"<nome>","<email>"
	And clico no botao 'salvar' 
	Then sistema retorna uma mensagem de erro "<validacao>"
	
	Examples: 
		|url							| nome      	     | email 	     			| validacao 		 |												 
		|http://localhost:8180/usuarios	| Lauro Barbosa      | 		   					| E-mail obrigatorio!|
		|http://localhost:8180/usuarios	|   		         |lauro.mrocha@gmail.com	| Nome obrigatorio!  |