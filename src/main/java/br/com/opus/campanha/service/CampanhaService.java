package br.com.opus.campanha.service;

import br.com.opus.campanha.enums.Status;
import br.com.opus.campanha.exception.EntidadeNaoEncontradaException;
import br.com.opus.campanha.model.Campanha;
import br.com.opus.campanha.model.Vaga;
import br.com.opus.campanha.model.dto.CampanhaDTO;
import br.com.opus.campanha.repository.CampanhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CampanhaService extends BaseService<Campanha, CampanhaDTO> {

    private static  final String ENTIDADE_NAO_ENCONTRADA = "Campanha não encontrada";

    private final CampanhaRepository repository;

    @Autowired
    public CampanhaService(CampanhaRepository repository) {
        this.repository = repository;
    }

    public Page<Campanha> buscarTodos(Pageable pageable) {
        return repository.findAllByStatus(pageable, Status.ATIVO.getValue());
    }

    public Campanha buscarPorId(Long id) {
        return repository.findByIdAndStatus(id, Status.ATIVO.getValue())
                .orElseThrow(() -> new EntidadeNaoEncontradaException(ENTIDADE_NAO_ENCONTRADA));
    }

    public Campanha incluir(Campanha campanha) {
        validarCampanha(campanha);
        return repository.save(campanha);
    }

    private void validarCampanha(Campanha entidade) {

    }

    public Campanha atualizar(Campanha entidade) {
        Campanha entidadeDb = buscarPorId(entidade.getId());
        mapper.map(entidade, entidadeDb);
        return repository.save(entidadeDb);
    }

    public void excluir(Long id) {
        Campanha entidade = buscarPorId(id);
        entidade.setStatus(Status.DESATIVADO.getValue());
        repository.save(entidade);

    }
}
