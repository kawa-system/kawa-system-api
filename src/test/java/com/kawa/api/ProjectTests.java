package com.kawa.api;

import com.kawa.api.models.Project;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * Unit Test Class dedicated to check {@link ProjectController}.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class ProjectTests {

    /** Local Server Port. */
    @LocalServerPort
    private int port;

    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** HTTP Status Code : Success (200). */
    private static final int STATUS_SUCCESS = 201;
    /** Default Project's ID. */
    private static final String DFT_ID = "default-id"; //$NON-NLS-1$
    /** Default Project's Name. */
    private static final String DFT_NAME = "default-name"; //$NON-NLS-1$
    /** Default Project's Description. */
    private static final String DFT_DESC = "default-description"; //$NON-NLS-1$

    /** Setter : Project's Name. */
    private static final String SET_NAME = "setter-name"; //$NON-NLS-1$
    /** Setter : Project's Description. */
    private static final String SET_DESC = "setter-description"; //$NON-NLS-1$

    /**
     * Used to post a project.
     * @param oProject The project to post.
     * @return The response entity.
     */
    private ResponseEntity<Project> postProject(final Project oProject) {
        try {
            return this.restTemplate.postForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                            + "/projects").toString(), //$NON-NLS-1$
                        oProject, Project.class);
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
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - All data sent")
    public void testProjectCreationWithAllDataSent() {
        /* Initialize Project. */
        final Project oProject = new Project(DFT_ID, DFT_NAME, DFT_DESC);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(STATUS_SUCCESS, oResponse.getStatusCodeValue());

        final Project oReturned = oResponse.getBody();
        Assertions.assertNotNull(oReturned,
                "Project cannot be null."); //$NON-NLS-1$

        Assertions.assertEquals(DFT_ID, oReturned.getUuid());
        Assertions.assertEquals(DFT_NAME, oReturned.getName());
        Assertions.assertEquals(DFT_DESC, oReturned.getDescription());
    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - All data sent through setters")
    public void testProjectCreationWithSetters() {
        /* Initialize Project. */
        final Project oProject = new Project(DFT_ID, DFT_NAME, DFT_DESC);
        oProject.setName(SET_NAME);
        oProject.setDescription(SET_DESC);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(STATUS_SUCCESS, oResponse.getStatusCodeValue());

        final Project oReturned = oResponse.getBody();
        Assertions.assertNotNull(oReturned,
                "Project cannot be null."); //$NON-NLS-1$

        Assertions.assertEquals(DFT_ID, oReturned.getUuid());
        Assertions.assertEquals(SET_NAME, oReturned.getName());
        Assertions.assertEquals(SET_DESC, oReturned.getDescription());

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - Without description")
    public void testProjectCreationWithoutDescription() {
        /* Initialize Project. */
        final Project oProject = new Project(DFT_ID, DFT_NAME, null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(STATUS_SUCCESS, oResponse.getStatusCodeValue());

        final Project oReturned = oResponse.getBody();
        Assertions.assertNotNull(oReturned,
                "Project cannot be null."); //$NON-NLS-1$

        Assertions.assertEquals(DFT_ID, oReturned.getUuid());
        Assertions.assertEquals(DFT_NAME, oReturned.getName());
        Assertions.assertNull(oReturned.getDescription());

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - Without UUID")
    public void testProjectCreationWithoutUuid() {
        /* Initialize Project. */
        final Project oProject = new Project(null, DFT_NAME, null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(STATUS_SUCCESS, oResponse.getStatusCodeValue());

        final Project oReturned = oResponse.getBody();
        Assertions.assertNotNull(oReturned,
                "Project cannot be null."); //$NON-NLS-1$

        Assertions.assertNotNull(DFT_ID, oReturned.getUuid());
        Assertions.assertEquals(DFT_NAME, oReturned.getName());
        Assertions.assertNull(oReturned.getDescription());

    }

}
