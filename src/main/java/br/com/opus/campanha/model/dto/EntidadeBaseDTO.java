package br.com.opus.campanha.model.dto;

import br.com.opus.campanha.model.EntidadeAPI;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EntidadeBaseDTO extends EntidadeAPI {

    private Long id;
}
