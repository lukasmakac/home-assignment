package no.itera.assignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "no.itera.assignment.repository")
public class RepositoryConfiguration {

}
