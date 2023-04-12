package br.com.opus.campanha.enums;

import lombok.Getter;

@Getter
public enum DiaSemana {

    DOMINGO("Domingo"),
    SEGUNDA("Segunda"),
    TERCA("Terça"),
    QUARTA("Quarta"),
    QUINTA("Quinta"),
    SEXTA("Sexta"),
    SABADO("Sabado");

    private String value;

    DiaSemana(String value) {
        this.value = value;
    }
}
