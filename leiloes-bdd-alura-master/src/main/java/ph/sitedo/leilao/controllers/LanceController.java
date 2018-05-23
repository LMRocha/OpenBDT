package ph.sitedo.leilao.controllers;

import ph.sitedo.leilao.models.Lance;
import ph.sitedo.leilao.repositories.LanceRepository;
import ph.sitedo.leilao.repositories.UsuarioRepository;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import java.util.Calendar;

@Resource
public class LanceController {

	private final LanceRepository lances;
	private final Result result;
	private final UsuarioRepository usuarios;

	public LanceController(Result result, UsuarioRepository usuarios, LanceRepository lances) {
		this.result = result;
		this.usuarios = usuarios;
		this.lances = lances;
	}
	
	@Post("/_lances")
	public void novoLance(Lance lance) {
		lance.setData(Calendar.getInstance());
		
		lances.salvar(lance);
		result.include("lance", lance);
		result.include("usuario", usuarios.find(lance.getUsuario().getId()));
	}
}
