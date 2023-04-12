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
@Table(name = "candidato_contato", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_candidato_contato", name = "id", schema = "opus", allocationSize = 1)
public class CandidatoContato extends EntidadeBase {

    @Column(nullable = false)
    private Boolean email = Boolean.FALSE;
    @Column(nullable = false)
    private Boolean whatsapp = Boolean.FALSE;
    @Column(nullable = false)
    private Boolean sms = Boolean.FALSE;
    @Column(nullable = false)
    private String mensagem;

    @OneToOne
    @JsonBackReference("candidato-contato")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;
}
