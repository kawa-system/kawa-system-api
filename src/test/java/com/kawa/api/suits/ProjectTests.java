package com.kawa.api.suits;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;
import com.kawa.api.controllers.ProjectController;
import com.kawa.api.models.ProjectDTO;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

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

    /** Default Project's Name. */
    private static final String DFT_NAME = "default-name"; //$NON-NLS-1$
    /** Default Project's Description. */
    private static final String DFT_DESC = "default-description"; //$NON-NLS-1$

    /** Setter : Project's Name. */
    private static final String SET_NAME = "setter-name"; //$NON-NLS-1$
    /** Setter : Project's Description. */
    private static final String SET_DESC = "setter-description"; //$NON-NLS-1$

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
     * @return The number of projects.
     */
    private int getNbProjects() {
        try {
            ResponseEntity<ProjectDTO[]> response =
                    this.restTemplate.getForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/projects").toString(), //$NON-NLS-1$
                    ProjectDTO[].class);

            return response.getBody().length;
        } catch (RestClientException rce) {
            Assertions.fail(rce);
            return -1;

        } catch (MalformedURLException mue) {
            Assertions.fail(mue);
            return -1;
        }

    }
    /**
     * Used to post a project.
     * @param oProject The project to post.
     * @return The response entity.
     */
    private ResponseEntity<ProjectDTO> postProject(final ProjectDTO oProject) {
        try {
            return this.restTemplate.postForEntity(
                    new URL("http://localhost:" + this.port //$NON-NLS-1$
                            + "/projects").toString(), //$NON-NLS-1$
                        oProject, ProjectDTO.class);
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
    @DisplayName("[POST /projects] - Nominal Case : Full Constructor")
    public void testNominalFullConstructor() {

        final String sUUID = UUID.randomUUID().toString();
        final int iNbBefore = getNbProjects();

        /* Initialize Project. */
        final ProjectDTO oProject = new ProjectDTO(sUUID,
            "   " + DFT_NAME + "   ", //$NON-NLS-1$ //$NON-NLS-2$
            "   " + DFT_DESC + "   "); //$NON-NLS-1$ //$NON-NLS-2$

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case."); //$NON-NLS-1$

        final int iNbAfter = getNbProjects();

        Assertions.assertTrue(iNbAfter > iNbBefore,
                "Number MUST increase."); //$NON-NLS-1$

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null."); //$NON-NLS-1$

        /* Assert project's attributes'. */
        Assertions.assertEquals(sUUID, oResponse.getBody().getUuid(),
            "The UUID of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_DESC, oResponse.getBody().getDescription(),
            "The description of the project MUST be the " //$NON-NLS-1$
            + "proposed one."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Minimal through Constructor.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Nominal Case : Full Constructor")
    public void testNominalMinimalConstructor() {

        /* Initialize Project. */
        final ProjectDTO oProject = new ProjectDTO(
            null,
            "   " + DFT_NAME + "   ", //$NON-NLS-1$ //$NON-NLS-2$
            null);

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case."); //$NON-NLS-1$

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null."); //$NON-NLS-1$

        /* Assert project's attributes'. */
        Assertions.assertNotNull(oResponse.getBody().getUuid(),
            "The UUID of the project CANNOT be null."); //$NON-NLS-1$
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals("", //$NON-NLS-1$
                oResponse.getBody().getDescription(),
            "The description of the project MUST be the " //$NON-NLS-1$
            + "proposed one."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Full through Setters.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Nominal Case : Setters")
    public void testNominalFullSetters() {

        final String sUUID = UUID.randomUUID().toString();

        /* Initialize Project. */
        final ProjectDTO oProject = new ProjectDTO(sUUID,
            DFT_NAME,
            DFT_DESC);
        oProject.setName(SET_NAME);
        oProject.setDescription(SET_DESC);

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case."); //$NON-NLS-1$

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null."); //$NON-NLS-1$

        /* Assert project's attributes'. */
        Assertions.assertEquals(sUUID, oResponse.getBody().getUuid(),
            "The UUID of the project CANNOT be null."); //$NON-NLS-1$
        Assertions.assertEquals(SET_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one."); //$NON-NLS-1$
        Assertions.assertEquals(SET_DESC, oResponse.getBody().getDescription(),
            "The description of the project MUST be the " //$NON-NLS-1$
            + "proposed one."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - UUID : UUID Used.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case : UUID Used")
    public void testUuidUsed() {
        final String sUUID = UUID.randomUUID().toString();

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(
                new ProjectDTO(sUUID, DFT_NAME, DFT_DESC));

        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "Creation Expected."); //$NON-NLS-1$

        /* Post Project. */
        final int iNbBefore = getNbProjects();
        final ResponseEntity<ProjectDTO> oResponse2 = postProject(
                new ProjectDTO(sUUID, SET_NAME, SET_DESC));
        final int iNbAfter = getNbProjects();

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse2.getStatusCode(),
            "Two projects with the same UUID CANNOT be created."); //$NON-NLS-1$

        Assertions.assertTrue(iNbAfter == iNbBefore,
                "Two projects with the same UUID CANNOT" //$NON-NLS-1$
                + " be created."); //$NON-NLS-1$
    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - UUID : Invalid Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case : Null")
    public void testNull() {

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(null);

        Assertions.assertEquals(
            HttpStatus.UNSUPPORTED_MEDIA_TYPE,
            oResponse.getStatusCode(),
            "Invalid UUID MUST generate a \"BAD REQUEST" //$NON-NLS-1$
                + "\" error."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - UUID : Invalid Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - UUID : Invalid")
    public void testUuidInvalid() {

        /* Initialize Project. */
        final ProjectDTO oProject = new ProjectDTO(
            "I AM AN INVALID UUID AND I F@!K U !", //$NON-NLS-1$
            DFT_NAME,
            null);

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Invalid UUID MUST generate a \"BAD REQUEST" //$NON-NLS-1$
                + "\" error."); //$NON-NLS-1$

    }

    /* @TODO APPEND A NOT NOMINAL TEST CASE FOR ALREADY USED UUID. */

    /**
     * Unit Test used to validate {@link ProjectController#create(ProjectDTO)}.
     * Not Nominal Case - Name : Null Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Null")
    public void testNameNull() {

        /* Initialize Project. */
        final ProjectDTO oProject = new ProjectDTO(
            null,
            null,
            null);

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(oProject);

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
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Too Small")
    public void testNameTooSmall() {

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(
                new ProjectDTO(UUID.randomUUID().toString(),
                ERR_NAME_TOO_SMALL,
                null));

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too small name MUST generate a " //$NON-NLS-1$
                + "\"BAD REQUEST\" error."); //$NON-NLS-1$

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(ProjectDTO)}.
     * Not Nominal Case - Name : Too Long Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Too Long")
    public void testNameTooLong() {

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(
                new ProjectDTO(UUID.randomUUID().toString(),
                        ERR_NAME_TOO_LONG,
                null));

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
    @DisplayName("[POST /projects] - Not Nominal Case - Description : Too Long")
    public void testDescriptionTooLong() {

        /* Post Project. */
        final ResponseEntity<ProjectDTO> oResponse = postProject(
                new ProjectDTO(UUID.randomUUID().toString(),
                        DFT_NAME,
                        ERR_DESC_TOO_LONG));

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too long description MUST generate a " //$NON-NLS-1$
                    + "\"BAD REQUEST\" error."); //$NON-NLS-1$

    }


}
