package br.com.opus.campanha.controller;

import br.com.opus.campanha.logger.LoggerStepEnum;
import br.com.opus.campanha.logger.LoggerUtil;
import br.com.opus.campanha.model.Campanha;
import br.com.opus.campanha.model.comum.ApiResponse;
import br.com.opus.campanha.model.constants.API;
import br.com.opus.campanha.model.constants.Permissoes;
import br.com.opus.campanha.model.dto.CampanhaDTO;
import br.com.opus.campanha.service.CampanhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = API.VERSAO + "/campanhas", produces = MediaType.APPLICATION_JSON_VALUE)
public class CampanhaController extends BaseController {

    @Autowired
    private CampanhaService service;

    @PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.BUSCARTODOS+ "')")
    @GetMapping
    public ApiResponse buscarTodos(Pageable pageable) {
        LoggerUtil.logger(LoggerStepEnum.CAM00001, pageable);
        ApiResponse apiResponse = preencherApiResponseComPaginacao(pageable,service.buscarTodos(pageable));
        LoggerUtil.logger(LoggerStepEnum.CAM00001, pageable, apiResponse);
        return apiResponse;
    }

    @PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.BUSCARPORID+ "')")
    @GetMapping("/{id}")
    public ApiResponse buscaPorId(@PathVariable Long id ) {
        LoggerUtil.logger(LoggerStepEnum.CAM00002, id);
        Campanha campanha = service.buscarPorId(id);
        LoggerUtil.logger(LoggerStepEnum.CAM00002, id, campanha);
        return ApiResponse.returnOk(campanha);

    }

    @PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.INCLUIR+ "')")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ApiResponse incluir(@RequestBody @Valid Campanha camp) {
        LoggerUtil.logger(LoggerStepEnum.CAM00003, camp);
        Campanha campanha = service.incluir(camp);
        LoggerUtil.logger(LoggerStepEnum.CAM00003, camp,campanha);
        return  ApiResponse.returnOk(campanha);
    }

    /*@PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.BUSCARTODOSFILTRO+ "')")
    @PostMapping("/filtro")
    public ApiResponse filtrar(Pageable pageable) {
        LoggerUtil.logger(LoggerStepEnum.CAM00001, filtros);

        ApiResponse apiResponse = preencherApiResponseComPaginacao(pageable, service.filtrar(filtros, pageable));

        LoggerUtil.logger(LoggerStepEnum.CAM00001, filtros, apiResponse);

        return apiResponse;
    }*/


    @PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.ATUALIZAR+ "')")
    @PutMapping
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ApiResponse atualizar(@RequestBody @Valid CampanhaDTO dto) {
        LoggerUtil.logger(LoggerStepEnum.CAM00004, dto);
        Campanha campanha = service.atualizar(service.converterDTOParaEntidade(dto));
        LoggerUtil.logger(LoggerStepEnum.CAM00004 ,campanha);

        return ApiResponse.returnOk();
    }

    @PreAuthorize("#oauth2.hasScope('campanha') || hasAuthority('" + Permissoes.CAMPANHA.EXCLUIR+ "')")
    @DeleteMapping("/{id}")
    public ApiResponse deleta(@PathVariable Long id) {
        LoggerUtil.logger(LoggerStepEnum.CAM00005, id);
        service.excluir(id);
        LoggerUtil.logger(LoggerStepEnum.CAM00005, id);
        return ApiResponse.returnOk();

    }
}
