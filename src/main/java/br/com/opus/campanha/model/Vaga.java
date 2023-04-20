package br.com.opus.campanha.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "vaga", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_vaga", name = "id", schema = "opus", allocationSize = 1)
public class Vaga extends EntidadeBase {

    @Column(nullable = false)
    private String funcao;

    @Column
    private BigDecimal salarioMin;

    @Column
    private BigDecimal salarioMax;

    @OneToOne
    @JsonBackReference("vaga")
    @JoinColumn(name = "campanha_id", referencedColumnName = "id")
    private Campanha campanha;

    @JsonManagedReference("tempo-exp")
    @OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL)
    private TempoExperiencia tempoExperiencia;

    @JsonManagedReference("nivel-ensino")
    @OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL)
    private NivelEnsino nivelEnsino;

    @JsonManagedReference("idiomas")
    @OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL)
    private Idiomas idiomas;

    @JsonManagedReference("campanha-responsavel")
    @OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL)
    private CampanhaResponsavel campanhaResponsavel;

    @JsonManagedReference("candidato-contato")
    @OneToOne(mappedBy = "vaga", cascade = CascadeType.ALL)
    private CandidatoContato candidatoContato;

    @ManyToMany
    @JoinTable(
            schema = "opus",
            name = "vaga_questao",
            joinColumns = @JoinColumn(name = "vaga_id"),
            inverseJoinColumns = @JoinColumn(name = "questao_id"))
    private Set<Questao> questoes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            schema = "opus",
            name = "vaga_tipo_contracao",
            joinColumns = @JoinColumn(name = "vaga_id"),
            inverseJoinColumns = @JoinColumn(name = "tipo_contracao_id"))
    private Set<TipoContratacao> tipoContratacoes = new HashSet<>();

    @JsonManagedReference("vaga-beneficio")
    @OneToMany(mappedBy = "vaga")
    private List<VagaBeneficio> beneficios = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            schema = "opus",
            name = "vaga_jornada_trabalho",
            joinColumns = @JoinColumn(name = "vaga_id"),
            inverseJoinColumns = @JoinColumn(name = "jornada_trabalho_id"))
    private Set<JornadaTrabalho> jornadasTrabalho = new HashSet<>();

}
