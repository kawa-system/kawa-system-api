package com.kawa.api.controllers;

import com.kawa.api.exceptions.AProjectException;
import com.kawa.api.models.Project;
import com.kawa.api.utils.ProjectUtils;

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
     *
     * @since 0.1.0 hydrogen
     */
    protected ProjectController() {
        super();
    }

    /**
     * Project creation.
     *
     * @param newProject project to create.
     * @return The response.
     * @throws AProjectException
     * @since 0.1.0 hydrogen
     */
    @PostMapping("/projects")
    public static ResponseEntity<Project> create(
        @RequestBody final Project newProject)
        throws AProjectException {
        final Project oValidProject;

        /* Check & Clean Project. */
        oValidProject = ProjectUtils.checkProjectToCreate(newProject);

        /* @TODO Persist Project in mongo db.... */

        /* Return new project as the resource representation. */
        return ResponseEntity.status(HttpStatus.CREATED).body(oValidProject);
    }

}
