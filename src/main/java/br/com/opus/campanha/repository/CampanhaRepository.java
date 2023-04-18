package br.com.opus.campanha.repository;

import br.com.opus.campanha.model.Campanha;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CampanhaRepository extends JpaRepository<Campanha, Long>, JpaSpecificationExecutor<Campanha> {

    Page<Campanha> findAllByStatus(Pageable pageable, Integer status);

    Optional<Campanha> findByIdAndStatus(Long id, Integer status);
}
