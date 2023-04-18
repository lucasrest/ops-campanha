package br.com.opus.campanha.repository.specification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class BaseSpecification<T> {

    private Specification<T> isAtivo() {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(
                        root.get("status"), 1L);
    }
}
