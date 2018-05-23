package ph.sitedo.leilao.repositories;

import javax.persistence.EntityManager;

import br.com.caelum.vraptor.ioc.Component;
import ph.sitedo.leilao.models.Usuario;

@Component
public class UsuarioRepositoryImpl
    extends Repository<Usuario, Long>
    implements UsuarioRepository {

	UsuarioRepositoryImpl(EntityManager entityManager) {
		super(entityManager);
	}
}
