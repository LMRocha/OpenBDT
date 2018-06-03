package br.com.openbdt.leiloes.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import br.com.openbdt.leiloes.utils.ColunasUsuarioEnum;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@Component
public class UsuariosPage extends PageObject{
	
	@FindBy(css = "h1")
	private WebElement lbPaginaTitulo;
	
	@FindBy(xpath = "//table/tbody/tr")
	private WebElement tabelaUsuarios;
	
	@FindBy(linkText="Novo Usuário")
	private WebElement btNovoUsuario;

	
	
	public WebElement getLbPaginaTitulo() {
		return lbPaginaTitulo;
	}

	public WebElement getTabelaUsuarios() {
		return tabelaUsuarios;
	}

	public WebElement getTabelaUsuarioCelulaEspecifica(ColunasUsuarioEnum nmColuna, String valor) {
		
		WebElement celula = null;
		List<WebElementFacade> coluna = new ArrayList<WebElementFacade>();
		coluna = findAll("//table/tbody/tr/td["+nmColuna.getValor()+"]");
		
		for (WebElement cell : coluna) {
			if(cell.getText().equals(valor)){
				celula = cell;
				break;
			}else{
				System.out.println("ELEMENTO NÃO ENCONTRADO NA TABELA");
			}
		}
		return celula;
	}
	
	public WebElement getBtNovoUsuario() {
		return btNovoUsuario;
	}
	
}
