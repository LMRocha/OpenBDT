package br.com.openbdt.leiloes.steps.definition;

import java.util.UUID;

import org.springframework.test.context.ContextConfiguration;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import br.com.openbdt.leiloes.steps.business.HomeStepBusiness;
import br.com.openbdt.leiloes.steps.business.StepBusiness;
import br.com.openbdt.leiloes.steps.business.UsuarioStepBusiness;
import net.thucydides.core.annotations.Steps;

@ContextConfiguration("/context.xml")
public class UsuariosStepDefinition {

	@Steps
	UsuarioStepBusiness uStepB;
	
}
