package br.com.openbdt.leiloes.steps.definition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.ContextConfiguration;

import br.com.openbdt.leiloes.steps.business.NovoLeilaoStepBusiness;
import br.com.openbdt.leiloes.steps.business.NovoUsuarioStepBusiness;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/context.xml")
public class NovoLeilaoStepDefinition {

	@Steps
	NovoLeilaoStepBusiness nLStepB;
	
	@Given("^estou na tela cadastro de leilao\"([^\"]*)\"$")
	public void estou_na_tela_cadastro_de_leilao(String url) throws Exception {
		nLStepB.openCadastraUsuario(url);
	}


	@When("^preencho os campos do formulario leilao\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencho_os_campos_do_formulario_leilao(String nome, String valorInicial, String usuario, String isUsado) throws Exception {
		Boolean usadoBool = false;
		if(isUsado.equalsIgnoreCase("sim"))
			usadoBool = true;
		nLStepB.preencheCamposFormulario(nome, valorInicial, usuario, usadoBool);
	}

	@When("^clico na opcao 'salvar'$")
	public void clico_na_opcao_salvar() throws Exception {
		nLStepB.clicaBotaoSalvar();
	}

	@Then("^sistema retorna para a pagina anterior \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
	public void sistema_retorna_para_a_pagina_anterior(String nome, String dataAbertura, String valorInicial, String usuario, String usado) throws Exception {
		List<String> valores = new ArrayList<String>();
		valores.add(0, nome);
		valores.add(1, dataAbertura);
		valores.add(2, valorInicial);
		valores.add(3, usuario);
		valores.add(4, usado);
		nLStepB.validaElementoInserido(valores);
	}

	@Then("^sistema exibe uma mensagem de erro no formulario leilao\"([^\"]*)\"$")
	public void sistema_exibe_uma_mensagem_de_erro_no_formulario_leilao(String mensagem) throws Exception {
		nLStepB.validaMensagensErro(mensagem);
	}

	
	
}
