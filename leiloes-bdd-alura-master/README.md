# Curso de BDD - Alura
---------------------------------------

Projeto desenvolvido durante o curso de BDD do [Alura](https://www.alura.com.br/)

## Sistema de Leilões
---------------------------------------

### Iniciando a Aplicação web:
---------------------------------------

Execute o seguinte comando em um terminal para empacotar e carregar a aplicação:

```
mvn package cargo:run
```
Depois abra um browser e acesse [http://localhost:8180/](http://localhost:8180/)

### Empacotando, realizando os testes e gerando o relatório do BDD:
---------------------------------------

Se a aplicação estiver rodando pare-a!

Depois execute o seguinte comando em um terminal:

```
mvn clean install
```

As ferramentas empacotarão o sistema, o executarão e farão os testes. Após isso será gerado um relatório com os resultados alcançados.

### Visualizando o relatório:
---------------------------------------

Após o comando acima o Serenity irá gerar um relatório com o resultado dos testes.

Para acessá-lo abra no browser de sua preferência o arquivo:

```
target/site/serenity/index.html
```
