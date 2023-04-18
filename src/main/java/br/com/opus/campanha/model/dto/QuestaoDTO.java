package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.enums.TipoQuestao;
import br.com.opus.campanha.model.EntidadeAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class QuestaoDTO extends EntidadeAPI {

    @NotNull
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipoQuestao;

    @NotNull
    private Integer ordem;

    @NotEmpty
    private String pergunta;

    @NotEmpty
    private String resposta;

    @JsonBackReference("questoes")
    private VagaDTO vaga;

}
