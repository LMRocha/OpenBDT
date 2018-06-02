package br.com.openbdt.leiloes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.pages.PageObject;

@Component
public class NovoUsuarioPage extends PageObject{

	@FindBy(name = "usuario.nome")
	private WebElement txtNomeUsuario;
	
	@FindBy(name="usuario.email")
	private WebElement txtEmail;
	
	@FindBy(id="btnSalvar")
	private WebElement btSalvar;
	
	@FindBy(linkText="Voltar")
	private WebElement btHrefVoltar;

	
	
	public WebElement getTxtNomeUsuario() {
		return txtNomeUsuario;
	}

	public WebElement getTxtEmail() {
		return txtEmail;
	}

	public WebElement getBtSalvar() {
		return btSalvar;
	}

	public WebElement getBtHrefVoltar() {
		return btHrefVoltar;
	}
	
	
	public String getPaginaSources(){
		return getDriver().getPageSource();
	}
	
}
