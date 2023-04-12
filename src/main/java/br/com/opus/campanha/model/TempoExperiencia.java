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
@Table(name = "tempo_experiencia", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_tempo_experiencia", name = "id", schema = "opus", allocationSize = 1)
public class TempoExperiencia extends EntidadeBase {

    @Column(nullable = false)
    private Boolean indiferente = Boolean.FALSE;

    @Column(name = "ate_6meses", nullable = false)
    private Boolean ate6Meses = Boolean.FALSE;

    @Column(name = "um_dois_anos", nullable = false)
    private Boolean umDoisAnos = Boolean.FALSE;

    @Column(name = "tres_quatro_anos", nullable = false)
    private Boolean tresQuatroAnos = Boolean.FALSE;

    @Column(name = "cinco_anos", nullable = false)
    private Boolean cincoAnos = Boolean.FALSE;

    @OneToOne
    @JsonBackReference("tempo-exp")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;

}
