package br.com.opus.campanha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficioDTO extends EntidadeBaseDTO {

    @NotEmpty
    private String descricao;

    @JsonBackReference("beneficios")
    private VagaDTO vaga;
}
