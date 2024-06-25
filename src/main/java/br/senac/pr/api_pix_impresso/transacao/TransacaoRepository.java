package br.senac.pr.api_pix_impresso.transacao;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import br.senac.pr.api_pix_impresso.shared.models.Transacao;

@Repository
public interface TransacaoRepository extends ListCrudRepository<Transacao, Long> {
}
