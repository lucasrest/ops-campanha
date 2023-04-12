package br.com.opus.campanha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_contracao", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_tipo_contracao", name = "id", schema = "opus", allocationSize = 1)
public class TipoContratacao extends EntidadeBase {

    @Column(nullable = false)
    private String descricao;
}
