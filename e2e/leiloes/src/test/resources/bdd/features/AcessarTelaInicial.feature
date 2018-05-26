Feature: Acessar a página inicial do sistema Leiloes

@usrum
Scenario Outline: Acessar a pagina inicial
  Given estou na home da aplicacao "<url>"
  Then sistema apresente tela inicial "<validacao>"

Examples:
   | url                                     | validacao |
   | http://localhost:8180/ 				 | Bem vindo ao projeto de leilão do curso online da Caelum! |
