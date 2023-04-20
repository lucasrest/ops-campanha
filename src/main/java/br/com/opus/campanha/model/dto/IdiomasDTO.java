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
public class IdiomasDTO extends EntidadeBaseDTO {

    @NotNull
    private Boolean indiferente = Boolean.FALSE;

    @NotNull
    private Boolean portugues = Boolean.FALSE;

    @NotNull
    private Boolean ingles = Boolean.FALSE;

    @NotNull
    private Boolean espanhol = Boolean.FALSE;

    @NotNull
    private Boolean frances = Boolean.FALSE;

    @NotNull
    private Boolean alemao = Boolean.FALSE;

    @NotNull
    private Boolean italiano = Boolean.FALSE;

    @NotNull
    private String outros;

    @JsonBackReference("idiomas")
    private VagaDTO vaga;
}
