package com.kawa.api.controllers;

import com.kawa.api.models.Project;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
     * Constructor.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    protected ProjectController() {
        super();
    }

    /**
     * Project creation.
     * @param newProject project to create.
     * @return The response.
     * @since 0.1.0 hydrogen
     */
    @PostMapping("/projects")
    public static ResponseEntity<Project> create(
        @RequestBody final Project newProject) {

        if (newProject == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (newProject.getUuid() == null) {
            return new ResponseEntity<Project>(
                new Project(UUID.randomUUID().toString(),
                newProject.getName(),
                newProject.getDescription()), HttpStatus.CREATED);
        }

        return new ResponseEntity<Project>(newProject, HttpStatus.CREATED);
    }

}
