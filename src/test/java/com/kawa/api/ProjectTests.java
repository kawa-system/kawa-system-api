package com.kawa.api;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;
import com.kawa.api.models.Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

/**
 * Unit Test Class dedicated to check {@link ProjectController}.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
public final class ProjectTests extends AKawaTests {
	
    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** Default Project's ID. */
    private static final String DFT_ID = UUID.randomUUID().toString();
    /** Default Project's Name. */
    private static final String DFT_NAME = "default-name"; //$NON-NLS-1$
    /** Default Project's Description. */
    private static final String DFT_DESC = "default-description"; //$NON-NLS-1$

    /** Setter : Project's Name. */
    private static final String SET_NAME = "setter-name"; //$NON-NLS-1$
    /** Setter : Project's Description. */
    private static final String SET_DESC = "setter-description"; //$NON-NLS-1$

    /** Invalid Name : Too Small. */
    private static final String ERR_NAME_TOO_SMALL; //$NON-NLS-1$
    static {
        final StringBuilder sBuilder = new StringBuilder();
        for (int i = 1; i < ProjectConstants.NAME_MINIMUM_SIZE; i++) {
            sBuilder.append('x');
        }
        ERR_NAME_TOO_SMALL = sBuilder.toString();
    }

    /** Invalid Name : Too long. */
    private static final String ERR_NAME_TOO_LONG; //$NON-NLS-1$
    static {
        final StringBuilder sBuilder2 = new StringBuilder();
        for (int i = 0; i <= ProjectConstants.NAME_MAXIMUM_SIZE; i++) {
            sBuilder2.append('X');
        }
        ERR_NAME_TOO_LONG = sBuilder2.toString();
    }

    /** Invalid Description : Too long. */
    private static final String ERR_DESC_TOO_LONG; //$NON-NLS-1$
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
     * Nominal Case : Full through Constructor.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Nominal Case : Full Constructor")
    public void testNominalFullConstructor() {

        /* Initialize Project. */
        final Project oProject = new Project(
            DFT_ID,
            "   " + DFT_NAME + "   ",
            "   " + DFT_DESC + "   ");

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case.");

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null.");

        /* Assert project's attributes'. */
        Assertions.assertEquals(DFT_ID, oResponse.getBody().getUuid(),
            "The UUID of the project MUST be the proposed one.");
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one.");
        Assertions.assertEquals(DFT_DESC, oResponse.getBody().getDescription(),
            "The description of the project MUST be the proposed one.");

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
        final Project oProject = new Project(
            null,
            "   " + DFT_NAME + "   ",
            null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case.");

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null.");

        /* Assert project's attributes'. */
        Assertions.assertNotNull(oResponse.getBody().getUuid(),
            "The UUID of the project CANNOT be null.");
        Assertions.assertEquals(DFT_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one.");
        Assertions.assertEquals("", oResponse.getBody().getDescription(),
            "The description of the project MUST be the proposed one.");

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Nominal Case : Full through Setters.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Nominal Case : Setters")
    public void testNominalFullSetters() {

        /* Initialize Project. */
        final Project oProject = new Project(
            DFT_ID,
            DFT_NAME,
            DFT_DESC);
        oProject.setName(SET_NAME);
        oProject.setDescription(SET_DESC);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        /* Assert expected status code. */
        Assertions.assertEquals(
            HttpStatus.CREATED,
            oResponse.getStatusCode(),
            "A valid project MUST be created in a nominal case.");

        /* Assert project instance. */
        Assertions.assertNotNull(oResponse.getBody(),
            "A created project CANNOT be null.");

        /* Assert project's attributes'. */
        Assertions.assertEquals(DFT_ID, oResponse.getBody().getUuid(),
            "The UUID of the project CANNOT be null.");
        Assertions.assertEquals(SET_NAME, oResponse.getBody().getName(),
            "The name of the project MUST be the proposed one.");
        Assertions.assertEquals(SET_DESC, oResponse.getBody().getDescription(),
            "The description of the project MUST be the proposed one.");

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
        final Project oProject = new Project(
            "I AM AN INVALID UUID AND I F@!K U !",
            DFT_NAME,
            null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Invalid UUID MUST generate a \"BAD REQUEST\" error.");

    }

    /* @TODO APPEND A NOT NOMINAL TEST CASE FOR ALREADY USED UUID. */

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Null Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Null")
    public void testNameNull() {

        /* Initialize Project. */
        final Project oProject = new Project(
            null,
            null,
            null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Null name MUST generate a \"BAD REQUEST\" error.");

    }


    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Too Small Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Too Small")
    public void testNameTooSmall() {

        /* Initialize Project. */
        final Project oProject = new Project(
            DFT_ID,
            ERR_NAME_TOO_SMALL,
            null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too small name MUST generate a \"BAD REQUEST\" error.");

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Too Long Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Name : Too Long")
    public void testNameTooLong() {

        /* Initialize Project. */
        final Project oProject = new Project(
            DFT_ID,
            ERR_NAME_TOO_LONG,
            null);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too long name MUST generate a \"BAD REQUEST\" error.");

    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}.
     * Not Nominal Case - Name : Too Long Case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /projects] - Not Nominal Case - Description : Too Long")
    public void testDescriptionTooLong() {

        /* Initialize Project. */
        final Project oProject = new Project(
            DFT_ID,
            DFT_NAME,
            ERR_DESC_TOO_LONG);

        /* Post Project. */
        final ResponseEntity<Project> oResponse = postProject(oProject);

        Assertions.assertEquals(
            HttpStatus.BAD_REQUEST,
            oResponse.getStatusCode(),
            "Too long description MUST generate a \"BAD REQUEST\" error.");

    }
}
