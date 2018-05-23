package ph.sitedo.leilao.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import ph.sitedo.leilao.models.Leilao;

@Component
public class LeilaoRepositoryImpl
    extends Repository<Leilao, Long>
    implements LeilaoRepository {

	LeilaoRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
