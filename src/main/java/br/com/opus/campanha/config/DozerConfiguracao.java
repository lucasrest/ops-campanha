package br.com.opus.campanha.config;

import br.com.opus.campanha.model.EntidadeBase;
import br.com.opus.campanha.model.dto.EntidadeBaseDTO;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DozerConfiguracao {

    @Bean
    public DozerBeanMapper mapper() {
        List<String> mappingFiles = new ArrayList();
        mappingFiles.add("dozerJdk8Converters.xml");

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(mappingFiles);
        mapper.addMapping(objectMappingBuilder);
        mapper.addMapping(objectMappingDTOBuilder);
        return mapper;
    }

    private BeanMappingBuilder objectMappingBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(EntidadeBase.class, EntidadeBase.class)
                    .exclude("inclusao")
                    .exclude("alteracao")
                    .exclude("uuid");
        }
    };

    BeanMappingBuilder objectMappingDTOBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {
            mapping(EntidadeBaseDTO.class, EntidadeBase.class)
                    .exclude("inclusao")
                    .exclude("alteracao")
                    .exclude("uuid");
        }
    };

}