package br.com.openbdt.leiloes.steps.business;

import java.util.List;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;

import br.com.openbdt.leiloes.pages.NovoUsuarioPage;
import br.com.openbdt.leiloes.pages.UsuariosPage;
import br.com.openbdt.leiloes.utils.ColunasUsuarioEnum;
import io.openbdt.element.WebBrowserScreenElement;
import jxl.common.Logger;

@ContextConfiguration("/context.xml")
@Component
public class NovoUsuarioStepBusiness {

	@Autowired
	UsuariosPage usuario;

	@Autowired
	NovoUsuarioPage novoUsuario;
	
	Logger LOG = Logger.getLogger(NovoUsuarioStepBusiness.class);

	@Autowired
	private WebBrowserScreenElement viewElement; // OBJETO QUE CONTÉM MÉTODOS
													// PRÓPRIOS DO FRAMEWORK
	
	public void openCadastraUsuario(String url) {
		viewElement.open(url);
		viewElement.clickAndWait(10, usuario.getBtNovoUsuario());
		viewElement.getDriver().manage().window().maximize();
	}

	public void preencheCamposFormulario(String nome, String email){
		viewElement.sendText(novoUsuario.getTxtNomeUsuario(), nome);
		viewElement.sendText(novoUsuario.getTxtEmail(), email);
	}
	
	public void clicaBotaoSalvar(){
		viewElement.waitAndClick(novoUsuario.getBtSalvar(), 10);
	}
	
	public void validaElementoInserido(List<String> valores){
		viewElement.waitForElementIsPresent(10, usuario.getTabelaUsuarios());
		
		LOG.info(">> " + usuario.getTabelaUsuarioCelulaEspecifica(ColunasUsuarioEnum.NOME, valores.get(0)).getText());
		Assert.assertEquals(valores.get(0), usuario.getTabelaUsuarioCelulaEspecifica(ColunasUsuarioEnum.NOME, valores.get(0)).getText());
		
		LOG.info(">> " + usuario.getTabelaUsuarioCelulaEspecifica(ColunasUsuarioEnum.EMAIL, valores.get(1)).getText());
		Assert.assertEquals(valores.get(1), usuario.getTabelaUsuarioCelulaEspecifica(ColunasUsuarioEnum.EMAIL, valores.get(1)).getText());
	}
	
	public void validaMensagensErro(String mensagem){
		LOG.info(">> " + this.novoUsuario.getPaginaSources().contains(mensagem));
		Assert.assertTrue(this.novoUsuario.getPaginaSources().contains(mensagem));
	}
	
}
