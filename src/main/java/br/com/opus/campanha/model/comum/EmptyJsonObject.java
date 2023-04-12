package br.com.opus.campanha.model.comum;

import br.com.opus.campanha.model.EntidadeAPI;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Builder
@NoArgsConstructor
@JsonSerialize
public class EmptyJsonObject extends EntidadeAPI {
}
