package br.com.opus.campanha.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CandidatoContatoDTO extends EntidadeBaseDTO {

    @NotNull
    private Boolean email = Boolean.FALSE;
    @NotNull
    private Boolean whatsapp = Boolean.FALSE;
    @NotNull
    private Boolean sms = Boolean.FALSE;
    @NotEmpty
    private String mensagem;

    @JsonBackReference("candidato-contato")
    private VagaDTO vaga;
}
