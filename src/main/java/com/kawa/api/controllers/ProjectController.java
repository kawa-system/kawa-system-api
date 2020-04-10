package com.kawa.api.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.owasp.encoder.Encode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawa.api.exceptions.AProjectException;
import com.kawa.api.models.ProjectDTO;
import com.kawa.api.repositories.ProjectRepository;
import com.kawa.api.utils.ProjectUtils;

/**
 * ProjectController.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@RestController
@RequestMapping("/projects")
public final class ProjectController {

    /** Mapper. */
    @Autowired
    private ModelMapper modelMapper;

    /** Repository. */
    @Autowired
    private ProjectRepository oProjectRepository;

    /**
     * Project creation.
     *
     * @param project project to create.
     * @return The response.
     * @throws AProjectException if failed to create the project.
     * @since 0.1.0 hydrogen
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Project> create(
        @RequestBody final Project project)
        throws AProjectException {

        /* Map model from request. */
        final Project newProject = mapPostedProject(project);

        /* Checking if UUID is already used. */
        if (StringUtils.isNotBlank(project.uuid)) {
            if (this.oProjectRepository.existsById(project.uuid)) {
                throw new AProjectException.UUIDUsed(project.uuid);
            }
        }

        final ProjectDTO oDto = newProject.toDto();
        this.modelMapper.map(oDto, ProjectDTO.class);
        this.oProjectRepository.save(oDto);

        /* Return new project as the resource representation. */
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(newProject);
    }

    /**
     * Return all projects.
     *
     * @return The response.
     * @since 0.1.0 hydrogen
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProjectDTO>> findAll() {
        return ResponseEntity.status(HttpStatus.FOUND)
            .body(this.oProjectRepository.findAll());
    }

    /** Project. */
    public static final class Project {

        /**
         * <b>UUID</b>.
         */
        private String uuid;

        /**
         * Short <b>Name</b>.
         */
        private String name;

        /**
         * <b>Description</b>.
         * @since 0.1.0 hydrogen
         */
        private String description;

        /**
         * Constructor.
         *
         * @param sUuid Initial UUID.
         * @param sName Initial Name.
         * @param sDescription Initial Description.
         * <hr>
         * @since 0.1.0 hydrogen
         */
        protected Project(
            final String sUuid,
            final String sName,
            final String sDescription
        ) {
            this.uuid = sUuid;
            this.name = sName;
            this.description = sDescription;
        }

        /**
         * Constructor.
         * <hr>
         * @since 0.1.0 hydrogen
         */
        protected Project() {
            super();
        }

        protected ProjectDTO toDto() {
            return new ProjectDTO(
                Encode.forJava(this.uuid),
                Encode.forJava(this.name),
                Encode.forJava(this.description));
        }

        /**
         * @return current UUID
         * <hr>
         * @since 0.1.0 hydrogen
         */
        public String getUuid() {
            return this.uuid;
        }

        /**
         * @return current short name.
         * <hr>
         * @since 0.1.0 hydrogen
         */
        public String getName() {
            return this.name;
        }

        /**
         * @return current UUID
         * <hr>
         * @since 0.1.0 hydrogen
         */
        public String getDescription() {
            return this.description;
        }

    }

    /**
     * Used to check & clean a given project candidate to a creation.
     * @param oToCheck The project to check.
     * @return A valid & clean project retrieved from request.
     * @throws AProjectException if, at least, one requirement is violated.
     */
    private static Project mapPostedProject(
        final Project oToCheck)
        throws AProjectException {

        return new Project(
            ProjectUtils.checkUuidToCreate(oToCheck.getUuid()),
            ProjectUtils.checkName(oToCheck.getName()),
            ProjectUtils.checkDescription(oToCheck.getDescription()));

    }

}
