package br.com.opus.campanha.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "beneficio", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_beneficio", name = "id", schema = "opus", allocationSize = 1)
public class Beneficio extends EntidadeBase {

    @Column(nullable = false)
    private String descricao;
}
