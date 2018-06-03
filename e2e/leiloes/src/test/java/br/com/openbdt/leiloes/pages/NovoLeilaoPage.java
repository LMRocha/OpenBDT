package br.com.openbdt.leiloes.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;

import net.serenitybdd.core.pages.PageObject;

@Component
public class NovoLeilaoPage extends PageObject{
	
	@FindBy(name = "leilao.nome")
	private WebElement txtNome;
	
	@FindBy(name = "leilao.valorInicial")
	private WebElement txtValorInicial;
	
	@FindBy(name = "leilao.usuario.id")
	private WebElement slctUsuarios;
	
	@FindBy(name = "leilao.usado")
	private WebElement ckboxUsado;
	
	@FindBy(tagName ="button")
	private WebElement btnSalvar;
	
	public WebElement getTxtNome() {
		return txtNome;
	}
		
	public WebElement getTxtValorInicial() {
		return txtValorInicial;
	}

	public WebElement getSlctUsuarios() {
		return slctUsuarios;
	}

	public WebElement getCkboxUsado() {
		return ckboxUsado;
	}
	
	public WebElement getBtnSalvar() {
		return btnSalvar;
	}
	
	public String getPaginaSources(){
		return getDriver().getPageSource();
	}
}
