package br.com.opus.campanha.enums;

import lombok.Getter;

@Getter
public enum TipoQuestao {

    SIM_NAO("Sim/Não"),

    MULTIPLA_ESCOLHA("Multipla Escolha"),

    ABERTA("Aberta");

    private String value;

    TipoQuestao(String value) {
        this.value = value;
    }
}
