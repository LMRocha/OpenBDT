package br.com.openbdt.leiloes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.pages.PageObject;

@Component
public class UsuariosPage extends PageObject{

	@FindBy(css = "h1")
	private WebElement lbPaginaTitulo;
	
	
	
	public WebElement getLbPaginaTitulo(){
		return this.lbPaginaTitulo;
	}
}
