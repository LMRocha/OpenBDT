package br.com.openbdt.leiloes.steps.business;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import br.com.openbdt.leiloes.pages.LeiloesPage;
import br.com.openbdt.leiloes.pages.NovoLeilaoPage;
import br.com.openbdt.leiloes.pages.NovoUsuarioPage;
import br.com.openbdt.leiloes.pages.UsuariosPage;
import br.com.openbdt.leiloes.utils.ColunasLeilaoEnum;
import br.com.openbdt.leiloes.utils.ColunasUsuarioEnum;
import io.openbdt.element.WebBrowserScreenElement;
import jxl.common.Logger;

@ContextConfiguration("/context.xml")
@Component
public class NovoLeilaoStepBusiness {

	@Autowired
	LeiloesPage leilao;

	@Autowired
	NovoLeilaoPage novoLeilao;
	
	Logger LOG = Logger.getLogger(NovoLeilaoStepBusiness.class);

	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS
													// PRÓPRIOS DO FRAMEWORK
	
	public void openCadastraUsuario(String url) {
		viewElement.open(url);
		viewElement.clickAndWait(10, leilao.getBtNovoLeilao());
		viewElement.getDriver().manage().window().maximize();
	}

	public void preencheCamposFormulario(String nome, String valorInicial, String usuario, Boolean isUsado){
		viewElement.sendText(novoLeilao.getTxtNome(), nome);
		viewElement.sendText(novoLeilao.getTxtValorInicial(), valorInicial);
		viewElement.selectByVisibleText(novoLeilao.getSlctUsuarios(), usuario);
		
		if(isUsado)
			viewElement.waitAndClick(novoLeilao.getCkboxUsado(), 10);
	}
	
	public void clicaBotaoSalvar(){
		viewElement.waitAndClick(novoLeilao.getBtnSalvar(), 10);
	}
	
	public void validaElementoInserido(List<String> valores){
		viewElement.waitForElementIsPresent(10, leilao.getTabelaLeiloes());		
		LOG.info(">> " + leilao.getTabelaLeilaoCelulaEspecifica(ColunasLeilaoEnum.NOME, valores.get(0)).getText());
		Assert.assertEquals(valores.get(0), leilao.getTabelaLeilaoCelulaEspecifica(ColunasLeilaoEnum.NOME, valores.get(0)).getText());
		System.out.println(valores.get(0) + ">>"+leilao.getTabelaLeilaoCelulaEspecifica(ColunasLeilaoEnum.NOME, valores.get(0)).getText());
	}
	
	public void validaMensagensErro(String mensagem){
		LOG.info(">> " + this.novoLeilao.getPaginaSources().contains(mensagem));
		Assert.assertTrue(this.novoLeilao.getPaginaSources().contains(mensagem));
	}
	
}
