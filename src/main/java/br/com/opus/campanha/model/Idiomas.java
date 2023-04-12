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
@Table(name = "idiomas", schema = "opus")
@SequenceGenerator(sequenceName = "opus.seq_idiomas", name = "id", schema = "opus", allocationSize = 1)
public class Idiomas extends EntidadeBase {

    @Column(nullable = false)
    private Boolean indiferente = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean portugues = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean ingles = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean espanhol = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean frances = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean alemao = Boolean.FALSE;

    @Column(nullable = false)
    private Boolean italiano = Boolean.FALSE;

    @Column(nullable = false)
    private String outros;

    @OneToOne
    @JsonBackReference("idiomas")
    @JoinColumn(name = "vaga_id", referencedColumnName = "id")
    private Vaga vaga;
}
