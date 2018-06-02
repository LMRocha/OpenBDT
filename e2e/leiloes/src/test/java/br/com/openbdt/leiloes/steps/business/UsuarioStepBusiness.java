package br.com.openbdt.leiloes.steps.business;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.openbdt.leiloes.pages.HomePage;
import br.com.openbdt.leiloes.pages.NovoUsuarioPage;
import br.com.openbdt.leiloes.pages.PageObjectClass;
import br.com.openbdt.leiloes.pages.UsuariosPage;
import jxl.common.Logger;
import net.serenitybdd.core.annotations.findby.By;

@ContextConfiguration("/context.xml")
@Component
public class UsuarioStepBusiness {

	@Autowired
	HomePage home;

	@Autowired
	UsuariosPage usuario;

	@Autowired
	NovoUsuarioPage novoUsuario;

	Logger LOG = Logger.getLogger(UsuarioStepBusiness.class);

	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS
													// PRÓPRIOS DO FRAMEWORK

	public void openCadastraUsuario(String url) {
		viewElement.open(url);
		viewElement.clickAndWait(10, usuario.getBtNovoUsuario());
		viewElement.getDriver().manage().window().maximize();
	}
	
	public void acessaNovoUsuario() {
		viewElement.waitForElementIsPresent(10, usuario.getBtNovoUsuario());
	}
}
