package com.kawa.api.controller;

import com.kawa.api.models.Project;
import java.util.UUID;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectController.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@RestController
public class ProjectController {

    /**
     * Project creation.
     * @param newProject project to create.
     * @return The response.
     * @since 0.1.0 hydrogen
     */
    @PostMapping("/project")
    public static Project create(@RequestBody Project newProject) {
        if (newProject.getUuid() == null) return new Project(UUID.randomUUID().toString(), newProject.getName(), newProject.getDescription());

        return newProject;
    }

}