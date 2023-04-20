package br.com.opus.campanha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VagaBeneficioDTO extends EntidadeBaseDTO {

    @JsonBackReference("vaga-beneficio")
    private VagaDTO vaga;

    private BeneficioDTO beneficio;
}
