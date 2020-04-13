package com.kawa.api.suits.controller.projects;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.constants.Constants;
import com.kawa.api.controller.projects.pojos.ProjectPost;
import com.kawa.api.controller.projects.pojos.ProjectGet;
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
@DisplayName("Controller >> Project >> Post")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class ProjectPostTests {

    /** Local Server Port. */
    @LocalServerPort
    private int port;

    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** Repository. */
    @Autowired
    private ProjectRepository projectRepository;

    /** Default Project's Name. */
    private static final String DFT_NAME = "default-name"; //$NON-NLS-1$
    /** Default Project's Description. */
    private static final String DFT_DESC = "default-description"; //$NON-NLS-1$

    /** Invalid Name : Too Small. */
    private static final String ERR_NAME_TOO_SMALL;
    static {
        final StringBuilder sBuilder = new StringBuilder();
        for (int i = 1; i < ProjectConstants.NAME_MINIMUM_SIZE; i++) {
            sBuilder.append('x');
        }
        ERR_NAME_TOO_SMALL = sBuilder.toString();
    }

    /** Invalid Name : Too long. */
    private static final String ERR_NAME_TOO_LONG;
    static {
        final StringBuilder sBuilder2 = new StringBuilder();
        for (int i = 0; i <= ProjectConstants.NAME_MAXIMUM_SIZE; i++) {
            sBuilder2.append('X');
        }
        ERR_NAME_TOO_LONG = sBuilder2.toString();
    }

    /** Invalid Description : Too long. */
    private static final String ERR_DESC_TOO_LONG;
    static {
        final StringBuilder sBuilder3 = new StringBuilder();
        for (int i = 0; i <= Constants.DEFAULT_MAXIMUM_LENGTH; i++) {
            sBuilder3.append('Z');
        }
        ERR_DESC_TOO_LONG = sBuilder3.toString();
    }

    /**
     * Used to post a project.
     * @param oProject The project to post.
     * @return The response entity.
     */
    private ResponseEntity<ProjectGet> postProject(
            final ProjectPost oProject) {
        try {
            return this.restTemplate.postForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                            + "/projects").toString(), //$NON-NLS-1$
                        oProject, ProjectGet.class);
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
    @DisplayName("Nominal Case (Full)")
    public void testNominalFullConstructor() {

        /* Initialize Project. */
        final ProjectPost oProject = new ProjectPost(
            "   " + DFT_NAME + "   ", //$NON-NLS-1$ //$NON-NLS-2$
            "   " + DFT_DESC + "   "); //$NON-NLS-1$ //$NON-NLS-2$

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case."); //$NON-NLS-1$

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null."); //$NON-NLS-1$

        /* Assert project's attributes'. */
        Assertions.assertNotNull(oResponse.getBody().getUUID(),
            "The UUID of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_DESC, oResponse.getBody().getDescription(),
            "The description of the project MUST be the " //$NON-NLS-1$
            + "proposed one."); //$NON-NLS-1$

        IProjectFactory oFactory = new ProjectFactory(this.projectRepository);
        try {
            oFactory.delete(oResponse.getBody().getUUID());
        } catch (ABusinessException e) {
            Assertions.fail(e);

        } catch (ATechnicalException e) {
                Assertions.fail(e);
        }

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Minimal through Constructor.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Nominal Case : Minimal")
    public void testNominalMinimalConstructor() {

        /* Initialize Project. */
        final ProjectPost oProject = new ProjectPost(
            "   " + DFT_NAME + "   ", //$NON-NLS-1$ //$NON-NLS-2$
            null);

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case."); //$NON-NLS-1$

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null."); //$NON-NLS-1$

        /* Assert project's attributes'. */
        Assertions.assertNotNull(oResponse.getBody().getUUID(),
            "The UUID of the project CANNOT be null."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals("", //$NON-NLS-1$
                oResponse.getBody().getDescription(),
            "The description of the project MUST be the " //$NON-NLS-1$
            + "proposed one."); //$NON-NLS-1$


        IProjectFactory oFactory = new ProjectFactory(this.projectRepository);
        try {
            oFactory.delete(oResponse.getBody().getUUID());
        } catch (ABusinessException e) {
            Assertions.fail(e);

        } catch (ATechnicalException e) {
                Assertions.fail(e);
        }

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - UUID : Invalid Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case : Null")
    public void testNull() {

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(null);

        Assertions.assertEquals(
            HttpStatus.UNSUPPORTED_MEDIA_TYPE,
            oResponse.getStatusCode(),
            "Invalid UUID MUST generate a \"BAD REQUEST" //$NON-NLS-1$
                + "\" error."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(ProjectGet)}.
     * Not Nominal Case - Name : Null Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case - Name : Null")
    public void testNameNull() {

        /* Initialize Project. */
        final ProjectPost oProject = new ProjectPost(null, null);

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Null name MUST generate a \"BAD REQUEST\" error."); //$NON-NLS-1$

    }


    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Too Small Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case - Name : Too Small")
    public void testNameTooSmall() {

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(
                new ProjectPost(ERR_NAME_TOO_SMALL, null));

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too small name MUST generate a " //$NON-NLS-1$
                + "\"BAD REQUEST\" error."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(ProjectGet)}.
     * Not Nominal Case - Name : Too Long Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case - Name : Too Long")
    public void testNameTooLong() {

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(
                new ProjectPost(ERR_NAME_TOO_LONG, null));

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too long name MUST generate a " //$NON-NLS-1$
                + "\"BAD REQUEST\" error."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Too Long Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case - Description : Too Long")
    public void testDescriptionTooLong() {

        /* Post Project. */
        final ResponseEntity<ProjectGet> oResponse = postProject(
                new ProjectPost(DFT_NAME, ERR_DESC_TOO_LONG));

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too long description MUST generate a " //$NON-NLS-1$
                    + "\"BAD REQUEST\" error."); //$NON-NLS-1$

    }

}
