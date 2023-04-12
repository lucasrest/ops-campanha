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
@Table(name = "nivel_ensino", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_nivel_ensino", name = "id", schema = "opus", allocationSize = 1)
public class NivelEnsino extends EntidadeBase {

    @Column(nullable = false)
    private Boolean indiferente = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean fundamental = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean tecnico = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean superior = Boolean.FALSE;

    @OneToOne
    @JsonBackReference("nivel-ensino")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;

}
