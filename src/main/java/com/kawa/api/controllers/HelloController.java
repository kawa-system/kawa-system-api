package com.kawa.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@RestController
public class HelloController {

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