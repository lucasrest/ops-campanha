package br.com.opus.campanha.controller;

import br.com.opus.campanha.model.comum.ApiResponse;
import br.com.opus.campanha.model.constants.API;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = API.VERSAO, produces = MediaType.APPLICATION_JSON_VALUE)
public class CampanhaController {

    @PreAuthorize("#oauth2.hasScope('agendamento')")
    @GetMapping("/teste")
    public ApiResponse enviarSms() {
        return ApiResponse.returnOk();
    }

}
