package com.kawa.api.suits.controller.projects;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.controller.projects.pojos.ProjectToCreate;
import com.kawa.api.model.projects.beans.ProjectBean;
import com.kawa.api.model.projects.constants.ProjectConstants;
import com.kawa.api.model.projects.faces.IProjectFactory;
import com.kawa.api.model.projects.factories.ProjectFactory;
import com.kawa.api.model.projects.repositories.ProjectRepository;

/**
 * Unit Test Class dedicated to check {@link ProjectController}.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Controller >> Project >> Get (Collection) ")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class ProjectGetCollectionTests {

    /** Local Server Port. */
    @LocalServerPort
    private int port;

    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** Repository. */
    @Autowired
    private ProjectRepository projectRepository;

    /**
     * @return The projects.
     */
    private ResponseEntity<ProjectBean[]> getProjects() {
        try {
            ResponseEntity<ProjectBean[]> response =
                    this.restTemplate.getForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/projects").toString(), //$NON-NLS-1$
                    ProjectBean[].class);

            return response;
        } catch (RestClientException rce) {
            Assertions.fail(rce);
            return null;

        } catch (MalformedURLException mue) {
            Assertions.fail(mue);
            return null;

        }

    }

    /**
     * Used to post a project.
     * @param oProject The project to post.
     * @return The response entity.
     */
    private ResponseEntity<ProjectBean> postProject(
            final ProjectToCreate oProject) {
        try {
            return this.restTemplate.postForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                            + "/projects").toString(), //$NON-NLS-1$
                        oProject, ProjectBean.class);
        } catch (RestClientException rce) {
            Assertions.fail(rce);
            return null;

        } catch (MalformedURLException mue) {
            Assertions.fail(mue);
            return null;
        }

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Full through Constructor.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Nominal Case")
    public void testOverload() {
        ResponseEntity<ProjectBean> postResponse;
        final List<String> uuidToDelete = new ArrayList<>();

        for (int i = 0; i < (2 * ProjectConstants.MAX_NB_PROJECT); i++) {
            postResponse = postProject(new ProjectToCreate(
                    "NAME_" + i, //$NON-NLS-1$
                    "DESCRIPTION_" + i)); //$NON-NLS-1$
            uuidToDelete.add(postResponse.getBody().getUuid());
        }

        ResponseEntity<ProjectBean[]> response = getProjects();

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.OK,
            response.getStatusCode());

        Assertions.assertTrue(
                response.getBody().length > 0);
        Assertions.assertTrue(
                response.getBody().length <= ProjectConstants.MAX_NB_PROJECT);

        IProjectFactory oFactory = new ProjectFactory(this.projectRepository);
        for (String sUUID : uuidToDelete) {
            try {
                oFactory.delete(sUUID);
            } catch (ABusinessException e) {
                Assertions.fail(e);

            } catch (ATechnicalException e) {
                Assertions.fail(e);
            }
        }

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Full through Constructor.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Overload")
    public void testNominal() {

        for (int i = 0; i < (ProjectConstants.MAX_NB_PROJECT * 2); i++) {
            postProject(new ProjectToCreate(
                    "NAME_" + i, //$NON-NLS-1$
                    "DESCRIPTION_" + i)); //$NON-NLS-1$
        }

        final ResponseEntity<ProjectBean[]> response = getProjects();

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.OK,
            response.getStatusCode());

        Assertions.assertTrue(
                response.getBody().length > 0);
        Assertions.assertTrue(
                response.getBody().length <= ProjectConstants.MAX_NB_PROJECT);

        IProjectFactory oFactory = new ProjectFactory(this.projectRepository);
        for (ProjectBean oBean : response.getBody()) {
            try {
                oFactory.delete(oBean.getUuid());
            } catch (ABusinessException e) {
                Assertions.fail(e);

            } catch (ATechnicalException e) {
                Assertions.fail(e);
            }
        }
    }

}
