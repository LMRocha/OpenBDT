package br.com.openbdt.leiloes.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.openbdt.leiloes.steps.business.HomeStepBusiness;
import br.com.openbdt.leiloes.steps.business.StepBusiness;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/context.xml")
public class HomeStepDefinition {

	@Steps
	HomeStepBusiness hStepB1;
	
	@Steps
	HomeStepBusiness hStepB2;
	
	@Given("^estou na home da aplicacao \"([^\"]*)\"$")
	public void estou_na_home_da_aplicacao(String url) throws Throwable {
		hStepB1.openHome(url);
	}

	@Then("^sistema apresente tela inicial \"([^\"]*)\"$")
	public void sistema_apresente_tela_inicial(String arg1) throws Throwable {
		hStepB1.validarTelaHome();
	}
	
	@Given("^estou na home da aplicacao Leiloes \"([^\"]*)\"$")
	public void estou_na_home_da_aplicacao_Leiloes(String url) throws Throwable {
		hStepB2.openHome(url);
	}
	
	@When("^clico na aba 'Usuarios'$")
	public void clico_na_aba_usuarios() throws Throwable {
		hStepB2.acessaAbaUsuarios();
	}

	@Then("^sistema apresenta o título da página Usuarios \"([^\"]*)\"$")
	public void sistema_apresente_titulo_pagina_usuarios(String arg1) throws Throwable {
		hStepB2.validarTelaUsuarios();
	}
	
}
