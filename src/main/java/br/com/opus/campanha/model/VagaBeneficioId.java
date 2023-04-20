package br.com.opus.campanha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class VagaBeneficioId extends EntidadeAPI {

    @Column(name = "vaga_id")
    private Long vagaId;

    @Column(name = "beneficio_id")
    private Long beneficioId;
}
