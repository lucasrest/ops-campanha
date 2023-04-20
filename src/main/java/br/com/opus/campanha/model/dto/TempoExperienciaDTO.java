package br.com.opus.campanha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TempoExperienciaDTO extends EntidadeBaseDTO {

    @NotNull
    private Boolean indiferente = Boolean.FALSE;

    @NotNull
    private Boolean ate6Meses = Boolean.FALSE;

    @NotNull
    private Boolean umDoisAnos = Boolean.FALSE;

    @NotNull
    private Boolean tresQuatroAnos = Boolean.FALSE;

    @NotNull
    private Boolean cincoAnos = Boolean.FALSE;

    @JsonBackReference("tempo-exp")
    private VagaDTO vaga;

}
