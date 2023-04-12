package br.com.opus.campanha.model;

import br.com.opus.campanha.anotation.DataAPI;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "campanha", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_campanha", name = "id", schema = "opus", allocationSize = 1)
public class Campanha extends EntidadeBase {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String nomeEmpresa;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Integer quantidadeVagas;

    @DataAPI
    @Column(nullable = false)
    private LocalDateTime inicio;

    @DataAPI
    @Column(nullable = false)
    private LocalDateTime fechamento;

    @Column
    private String areaInteresse;

    @Column
    private String palavraChave;

    @Column(nullable = false)
    private Boolean exclusivoPcd = Boolean.FALSE;

    @Column
    private String observacao;

    @JsonManagedReference("vaga")
    @OneToOne(mappedBy = "campanha", cascade = CascadeType.ALL)
    private Vaga vaga;

}
