package br.com.opus.campanha.model;

import br.com.opus.campanha.anotation.DataAPI;
import br.com.opus.campanha.enums.DiaSemana;
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
@Table(name = "tempo_experiencia", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_tempo_experiencia", name = "id", schema = "opus", allocationSize = 1)
public class JornadaTrabalho extends EntidadeBase {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DiaSemana diaSemana;

    @DataAPI
    @Column
    private LocalDateTime inicio;

    @DataAPI
    @Column(name = "final", nullable = false)
    private LocalDateTime dtFinal;

}
