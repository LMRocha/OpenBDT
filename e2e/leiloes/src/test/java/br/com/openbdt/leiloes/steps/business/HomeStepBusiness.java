package br.com.openbdt.leiloes.steps.business;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import io.openbdt.element.WebBrowserScreenElement;
import br.com.openbdt.leiloes.pages.HomePage;
import br.com.openbdt.leiloes.pages.PageObjectClass;
import jxl.common.Logger;
import net.serenitybdd.core.annotations.findby.By;

@ContextConfiguration("/context.xml")
@Component
public class HomeStepBusiness {

	@Autowired
	HomePage home;
	
	Logger LOG = Logger.getLogger(HomeStepBusiness.class);
	
	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS PRÓPRIOS DO FRAMEWORK

	public void openHome(String url) {
		viewElement.open(url);
		viewElement.getDriver().manage().window().maximize();
	}

	public void validarTelaHome() {
		viewElement.waitForElementIsPresent(20, home.getLbBoasVindas());
		LOG.info(">> " + home.getLbBoasVindas().getText());
		Assert.assertEquals("Bem vindo ao projeto de leilão do curso online da Caelum!", home.getLbBoasVindas().getText());
	}
	
}
