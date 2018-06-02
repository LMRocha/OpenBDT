package br.com.openbdt.leiloes.steps.definition;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.ContextConfiguration;

import br.com.openbdt.leiloes.steps.business.NovoUsuarioStepBusiness;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/context.xml")
public class NovoUsuariosStepDefinition {

	@Steps
	NovoUsuarioStepBusiness nUStepB;
	
	@Given("^estou na tela cadastro de usuario\"([^\"]*)\"$")
	public void estou_na_tela_cadastro_de_usuario(String arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		nUStepB.openCadastraUsuario(arg1);
	}

	@When("^preencho os campos do formulario\"([^\"]*)\",\"([^\"]*)\"$")
	public void preencho_os_campos_do_formulario(String arg1, String arg2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		nUStepB.preencheCamposFormulario(arg1, arg2);
	}

	@When("^clico no botao 'salvar'$")
	public void clico_no_botao_salvar() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		nUStepB.clicaBotaoSalvar();
	}

	@Then("^sistema retorna para a pagina anterior \"([^\"]*)\",\"([^\"]*)\"$")
	public void sistema_retorna_para_a_pagina_anterior(String arg1, String arg2) throws Exception {
		System.out.println("VALORES: "+ arg1 +" "+ arg2);
		
		List<String> valores = new ArrayList<String>();
		valores.add(0, arg1);
		valores.add(1, arg2);
		nUStepB.validaElementoInserido(valores);
	}
	
	
	@Then("^sistema retorna uma mensagem de erro \"([^\"]*)\"$")
	public void sistema_retorna_uma_mensagem_de_erro(String arg) throws Exception {
		nUStepB.validaMensagensErro(arg);
	}

	
	
}
