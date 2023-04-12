package br.com.opus.campanha.config;

import br.com.opus.campanha.exception.handler.ExceptionFilter;
import br.com.opus.campanha.exception.handler.HttpForbiddenEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(new ExceptionFilter(), BasicAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers("/actuator/health",
                        "/**"
                ).permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(new HttpForbiddenEntryPoint());
    }
}