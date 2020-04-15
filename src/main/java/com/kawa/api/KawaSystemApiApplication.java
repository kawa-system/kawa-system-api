package com.kawa.api;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

/**
 * Application.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@SpringBootApplication
@RestController
public class KawaSystemApiApplication {

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    protected KawaSystemApiApplication() {
        super();
    }

    /**
     * Main {@code method}.
     * @param args Native Arguments.
     * @since 0.1.0 hydrogen
     */
    public static void main(final String[] args) {
        SpringApplication.run(KawaSystemApiApplication.class, args);
    }

    @Bean
    public static ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
