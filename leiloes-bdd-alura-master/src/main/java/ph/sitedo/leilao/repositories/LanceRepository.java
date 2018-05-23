package ph.sitedo.leilao.repositories;

import ph.sitedo.leilao.models.Lance;

public interface LanceRepository {

	void salvar(Lance lance);
	Lance porId(Long id);
}
