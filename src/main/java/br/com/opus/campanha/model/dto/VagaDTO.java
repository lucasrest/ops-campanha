package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.model.EntidadeAPI;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO extends EntidadeAPI {

    @NotEmpty
    private String funcao;

    private BigDecimal salarioMin;

    private BigDecimal salarioMax;

    @JsonBackReference("vaga")
    private CampanhaDTO campanha;

    @JsonManagedReference("tempo-exp")
    private TempoExperienciaDTO tempoExperiencia;

    @JsonManagedReference("nivel-ensino")
    private NivelEnsinoDTO nivelEnsino;

    @JsonManagedReference("idiomas")
    private IdiomasDTO idiomas;

    @JsonManagedReference("campanha-responsavel")
    private CampanhaResponsavelDTO campanhaResponsavel;

    @JsonManagedReference("candidato-contato")
    private CandidatoContatoDTO candidatoContato;

    @JsonManagedReference("questoes")
    private Set<QuestaoDTO> questoes = new HashSet<>();

    @JsonManagedReference("tipo-contratacoes")
    private Set<TipoContratacaoDTO> tipoContratacoes = new HashSet<>();

    @JsonManagedReference("beneficios")
    private Set<BeneficioDTO> beneficios = new HashSet<>();

    @JsonManagedReference("jornadas-trabalho")
    private Set<JornadaTrabalhoDTO> jornadasTrabalho = new HashSet<>();

}
