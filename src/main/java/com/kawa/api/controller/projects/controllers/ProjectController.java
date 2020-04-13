package com.kawa.api.controller.projects.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.controller.projects.pojos.ProjectGet;
import com.kawa.api.controller.projects.pojos.ProjectPost;
import com.kawa.api.model.projects.faces.IProject;
import com.kawa.api.model.projects.faces.IProjectFactory;
import com.kawa.api.model.projects.factories.ProjectFactory;
import com.kawa.api.model.projects.repositories.ProjectRepository;

/**
 * ProjectController.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@RestController
@RequestMapping("/projects")
public final class ProjectController {

    /** Repository. */
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * Project creation.
     *
     * @param project project to create.
     * @return The response.
     * @throws ATechnicalException in case of technical issue.
     * @throws ABusinessException in case of a requirement violation.
     * @since 0.1.0 hydrogen
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectGet> create(
        @RequestBody final ProjectPost project)
        throws ATechnicalException, ABusinessException {

        final IProjectFactory factory
            = new ProjectFactory(this.projectRepository);

        final IProject iProject = factory.create(
                project.getName(),
                project.getDescription());

        /* Return new project as the resource representation. */
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new ProjectGet(iProject));
    }

    /**
     * Return all projects.
     *
     * @return The response.
     * @throws ATechnicalException in case of technical issue.
     * @throws ABusinessException in case of a requirement violation.
     * @since 0.1.0 hydrogen
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectGet>> findAll()
            throws ATechnicalException, ABusinessException {

        final IProjectFactory factory
            = new ProjectFactory(this.projectRepository);

        final List<ProjectGet> projects = new ArrayList<>();
        for (IProject iProject : factory.findAll()) {
            projects.add(new ProjectGet(iProject));
        }

        return ResponseEntity.status(HttpStatus.OK)
            .body(projects);
    }

}
