package br.com.opus.campanha.model;

import br.com.opus.campanha.enums.TipoQuestao;
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
@Table(name = "questao", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_questao", name = "id", schema = "opus", allocationSize = 1)
public class Questao extends EntidadeBase {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoQuestao tipoQuestao;

    @Column(nullable = false)
    private Integer ordem;

    @Column(nullable = false)
    private String pergunta;

    @Column(nullable = false)
    private String resposta;

}
