package br.com.openbdt.leiloes.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;

@Component
public class UsuariosPage extends PageObject{
	
	@FindBy(css = "h1")
	private WebElement lbPaginaTitulo;
	
	@FindBys({
		@FindBy(xpath = "//table/tbody/tr")
	} )
	private List<WebElement> tabelaUsuarios;
	
	@FindBy(linkText="Novo Usuário")
	private WebElement btNovoUsuario;

	
	
	public WebElement getLbPaginaTitulo() {
		return lbPaginaTitulo;
	}

	public List<WebElement> getTabelaUsuarios() {
		return tabelaUsuarios;
	}

	public WebElement getTabelaUsuarioCelulaEspecifica(List<WebElement> tabelaUsuarios, ColunasUsuariosEnum nmColuna, String valor) {
		
		int index = 0;
		WebElement celula = null;
		List<WebElement> coluna = new ArrayList<WebElement>();
		
		for (WebElement element : tabelaUsuarios) {
			coluna = element.findElements(By.xpath("td["+nmColuna.getValor()+""));
			
			if(coluna.get(index).getText().equals(valor)){
				celula = coluna.get(index);
				break;
			}
		}
		
		return celula;
	}
	
	public WebElement getBtNovoUsuario() {
		return btNovoUsuario;
	}
	
}

enum ColunasUsuariosEnum{

	NOME(1), 
	EMAIL(2), 
	ACAO(3);
	
	private int valor;
	
	private ColunasUsuariosEnum(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}