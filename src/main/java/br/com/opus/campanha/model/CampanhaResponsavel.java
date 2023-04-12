package br.com.opus.campanha.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "campanha_responsavel", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_campanha_responsavel", name = "id", schema = "opus", allocationSize = 1)
public class CampanhaResponsavel extends EntidadeBase {

    @Column
    private String nome;
    @Column
    private String email;
    @Column
    private String telefone;

    @OneToOne
    @JsonBackReference("campanha-responsavel")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;

}
