Feature: Acessar a página usuarios do sistema Leiloes 

@usrum 
Scenario Outline: Acessar a pagina Novo Usuario 
	Given estou na tela de usuarios "<url>" 
	Then sistema apresenta o título da página Usuarios "<validacao>" 
	
	Examples: 
		| url                                    | validacao |												 
		| http://localhost:8180/ 				 | Todos os Usuários |