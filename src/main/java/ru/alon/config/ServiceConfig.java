package ru.alon.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Конфигурация сервиса
 */
@Configuration
@EnableJpaRepositories(value = "ru.alon.repository")
@EntityScan("ru.alon.entity")
public class ServiceConfig {
}
