package com.ehizman.drones;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@Configuration
@EnableJpaRepositories(basePackages = {"com.ehizman.drones.data.repository"})
public class DataConfig {
}
