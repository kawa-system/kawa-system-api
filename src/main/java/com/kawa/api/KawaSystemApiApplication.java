package com.kawa.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public KawaSystemApiApplication() {
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

    /**
     * Hello World Service.
     * @param name The name to display.
     * @return The response.
     * @since 0.1.0 hydrogen
     */
    @GetMapping("/hello")
    public static String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name); //$NON-NLS-1$
    }

}
