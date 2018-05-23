package ph.sitedo.leilao.controllers;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;

import javax.persistence.EntityManager;

@Resource
public class TesteController {
	
	private EntityManager em;
	
	public TesteController(EntityManager em) {
		this.em = em;
	} 
	
	@Get("/apenas-teste/limpa")
	public void index() {
		em.createNativeQuery("delete from lance").executeUpdate();
		em.createNativeQuery("delete from leilao").executeUpdate();
		em.createNativeQuery("delete from usuario").executeUpdate();
	}
}