package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.model.EntidadeAPI;
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
public class TipoContratacaoDTO extends EntidadeAPI {

    @NotEmpty
    private String descricao;

    @JsonBackReference("tipo-contratacoes")
    private VagaDTO vaga;
}
