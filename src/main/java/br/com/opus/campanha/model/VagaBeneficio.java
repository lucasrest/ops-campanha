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
@Table(name = "vaga_beneficio", schema = "opus")
public class VagaBeneficio extends EntidadeAPI {

    @EmbeddedId
    private VagaBeneficioId id;

    @ManyToOne
    @MapsId("vagaId")
    @JsonBackReference("vaga-beneficio")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;

    @ManyToOne
    @MapsId("beneficioId")
    @JoinColumn(name = "beneficio_id", referencedColumnName = "id")
    private Beneficio beneficio;
}
