package br.com.opus.campanha.service;

import org.dozer.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseService<E, D>  {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    protected Mapper mapper;

    public E converterDTOParaEntidade(D dto) {
        Class<?> classeDoTipoParametrizado = getClasseDoTipoParametrizado(0);
        return modelMapper.map(dto, (Type) classeDoTipoParametrizado);
    }

    public D converterEntidadeParaDTO(E entidade) {
        Class<?> classeDoTipoParametrizado = getClasseDoTipoParametrizado(1);
        return modelMapper.map(entidade, (Type) classeDoTipoParametrizado);
    }

    private Class<?> getClasseDoTipoParametrizado(Integer posicao) {
        return (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[posicao];
    }

}
