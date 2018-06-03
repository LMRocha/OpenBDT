package br.com.openbdt.leiloes.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import br.com.openbdt.leiloes.utils.ColunasLeilaoEnum;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

@Component
public class LeiloesPage extends PageObject{
	
	@FindBy(css = "h1")
	private WebElement lbPaginaTitulo;
	
	@FindBy(xpath = "//table/tbody/tr")
	private WebElement tabelaLeiloes;
	
	@FindBy(linkText="Novo Leilão")
	private WebElement btNovoLeilao;

	
	
	public WebElement getLbPaginaTitulo() {
		return lbPaginaTitulo;
	}

	public WebElement getTabelaLeiloes() {
		return tabelaLeiloes;
	}

	public WebElement getTabelaLeilaoCelulaEspecifica(ColunasLeilaoEnum nmColuna, String valor) {
		
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
	
	public WebElement getBtNovoLeilao() {
		return btNovoLeilao;
	}
	
}
