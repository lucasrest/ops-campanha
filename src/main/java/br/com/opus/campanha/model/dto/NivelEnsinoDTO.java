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
public class NivelEnsinoDTO extends EntidadeBaseDTO {

    @NotNull
    private Boolean indiferente = Boolean.FALSE;

    @NotNull
    private Boolean fundamental = Boolean.FALSE;

    @NotNull
    private Boolean tecnico = Boolean.FALSE;

    @NotNull
    private Boolean superior = Boolean.FALSE;

    @JsonBackReference("nivel-ensino")
    private VagaDTO vaga;

}
