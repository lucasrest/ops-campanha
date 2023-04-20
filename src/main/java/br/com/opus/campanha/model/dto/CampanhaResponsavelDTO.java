package br.com.opus.campanha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampanhaResponsavelDTO extends EntidadeBaseDTO {

    private String nome;
    private String email;
    private String telefone;

    @JsonBackReference("campanha-responsavel")
    private VagaDTO vaga;

}
