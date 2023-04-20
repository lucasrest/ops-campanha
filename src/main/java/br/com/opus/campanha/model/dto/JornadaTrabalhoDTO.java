package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.anotation.DataAPI;
import br.com.opus.campanha.enums.DiaSemana;
import br.com.opus.campanha.model.EntidadeAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JornadaTrabalhoDTO extends EntidadeBaseDTO {

    @Enumerated(EnumType.STRING)
    @NotNull
    private DiaSemana diaSemana;

    @DataAPI
    private LocalDateTime inicio;

    @DataAPI
    private LocalDateTime dtFinal;

    @JsonBackReference("jornadas-trabalho")
    private VagaDTO vaga;

}
