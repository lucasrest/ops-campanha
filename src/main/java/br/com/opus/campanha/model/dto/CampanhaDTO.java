package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.anotation.DataAPI;
import br.com.opus.campanha.model.EntidadeAPI;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CampanhaDTO extends EntidadeAPI {

    @NotEmpty
    private String nome;

    @NotEmpty
    private String nomeEmpresa;

    @NotEmpty
    private String descricao;

    @NotNull
    private Integer quantidadeVagas;

    @DataAPI
    @NotNull
    private LocalDateTime inicio;

    @DataAPI
    @NotNull
    private LocalDateTime fechamento;

    private String areaInteresse;

    private String palavraChave;

    @NotNull
    private Boolean exclusivoPcd = Boolean.FALSE;

    private String observacao;

    @JsonManagedReference("vaga")
    private VagaDTO vaga;

}
