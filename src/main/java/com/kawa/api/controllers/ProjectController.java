package com.kawa.api.controllers;

import java.util.List;

import com.kawa.api.exceptions.AProjectException;
import com.kawa.api.models.Project;
import com.kawa.api.repositories.ProjectRepository;
import com.kawa.api.utils.ProjectUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectController.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository oProjectRepository;

    /**
     * Project creation.
     *
     * @param newProject project to create.
     * @return The response.
     * @throws AProjectException
     * @since 0.1.0 hydrogen
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> create(
        @RequestBody final Project newProject)
        throws AProjectException {
        final Project oValidProject;

        /* Check & Clean Project. */
        oValidProject = ProjectUtils.checkProjectToCreate(newProject);

        this.oProjectRepository.save(oValidProject);

        /* Return new project as the resource representation. */
        return ResponseEntity.status(HttpStatus.CREATED).body(oValidProject);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> findAll() {
        List<Project> projects = this.oProjectRepository.findAll();

        return ResponseEntity.status(HttpStatus.FOUND).body(projects);
    }

}
