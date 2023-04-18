package br.com.opus.campanha.logger;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LoggerStepEnum {
    CAM00001("[CampanhaController] - [buscartodos]"),
    CAM00002("[CampanhaController] - [buscaPorId]"),
    CAM00003("[CampanhaController] - [incluir]"),
    CAM00004("[CampanhaController] - [atualizar]"),
    CAM00005("[CampanhaController] - [deletar]"),

    ERR0090("Erro");

    private String message;

    public String getMessage() {
        return message;
    }

}
