package no.itera.assignment.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.itera.assignment.mapper.Mapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class MapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json().build();
    }

    @Bean
    public Mapper mapper() {
        return new Mapper();
    }

}
