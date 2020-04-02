package com.kawa.api.controllers;

import java.util.List;

import com.kawa.api.dto.ProjectDTO;
import com.kawa.api.exceptions.AProjectException;
import com.kawa.api.models.Project;
import com.kawa.api.repositories.ProjectRepository;
import com.kawa.api.utils.ProjectUtils;

import org.modelmapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Autowired
    private ProjectRepository oProjectRepository;

    /**
     * Project creation.
     *
     * @param projectDTO project to create.
     * @return The response.
     * @throws AProjectException
     * @since 0.1.0 hydrogen
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> create(
        @RequestBody final ProjectDTO projectDTO)
        throws AProjectException {
        Project newProject = modelMapper.map(projectDTO, Project.class);
        final Project oValidProject;

        /* Check & Clean Project. */
        oValidProject = ProjectUtils.checkProjectToCreate(newProject);

        this.oProjectRepository.save(oValidProject);

        /* Return new project as the resource representation. */
        return ResponseEntity.status(HttpStatus.CREATED).body(oValidProject);
    }

    /**
     * Return all projects.
     *
     * @return The response.
     * @since 0.1.0 hydrogen
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Project>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND).body(this.oProjectRepository.findAll(););
    }

}
