Feature: Acessar a página usuarios do sistema Leiloes 

@usrum 
Scenario Outline: Acessar a pagina Usuarios 
	Given estou na home da aplicacao Leiloes "<url>" 
	When clico na aba 'Usuarios' 
	Then sistema apresenta o título da página Usuarios "<validacao>" 
	
	Examples: 
		| url                                    | validacao |												 
		| http://localhost:8180/ 				 | Todos os Usuários |
