package com.kawa.api;

import com.kawa.api.models.Project;
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

/**
 * Unit Test Class dedicated to check {@link KawaSystemApiApplication}.
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "Papa Bear" ROLLE</a>
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

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - All data sent")
    public void testProjectCreationWithAllDataSent() throws Exception {
        Project project = new Project("TestID", "TestName", "TestDescription");

        ResponseEntity<Project> response = this.restTemplate.postForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/project").toString(), project, Project.class); //$NON-NLS-1$

        Assertions.assertEquals(200, response.getStatusCodeValue());
	    Assertions.assertEquals("TestID", //$NON-NLS-1$
	            response.getBody().getUuid());
	    Assertions.assertEquals("TestName", //$NON-NLS-1$
	            response.getBody().getName());
	    Assertions.assertEquals("TestDescription", //$NON-NLS-1$
	            response.getBody().getDescription());
    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - Without description")
    public void testProjectCreationWithoutDescription() throws Exception {
        Project project = new Project("TestID", "TestName", null);

        ResponseEntity<Project> response = this.restTemplate.postForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/project").toString(), project, Project.class); //$NON-NLS-1$

        Assertions.assertEquals(200, response.getStatusCodeValue());
	    Assertions.assertEquals("TestID", //$NON-NLS-1$
	            response.getBody().getUuid());
	    Assertions.assertEquals("TestName", //$NON-NLS-1$
	            response.getBody().getName());
	    Assertions.assertNull(response.getBody().getDescription());
    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - Without UUID")
    public void testProjectCreationWithoutUuid() throws Exception {
        Project project = new Project(null, "TestName", "TestDescription");

        ResponseEntity<Project> response = this.restTemplate.postForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/project").toString(), project, Project.class); //$NON-NLS-1$

        Assertions.assertEquals(200, response.getStatusCodeValue());
	    Assertions.assertNotNull(response.getBody().getUuid());
	    Assertions.assertEquals("TestName", //$NON-NLS-1$
	            response.getBody().getName());
	    Assertions.assertEquals("TestDescription", //$NON-NLS-1$
	            response.getBody().getDescription());
    }

    /**
     * Unit Test used to validate {@link ProjectController#create(Project)}
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[POST /project] Nominal Case - Without UUID and description")
    public void testProjectCreationWithoutUuidAndDescription() throws Exception {
        Project project = new Project(null, "TestName", null);

        ResponseEntity<Project> response = this.restTemplate.postForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/project").toString(), project, Project.class); //$NON-NLS-1$

        Assertions.assertEquals(200, response.getStatusCodeValue());
	    Assertions.assertNotNull(response.getBody().getUuid());
	    Assertions.assertEquals("TestName", //$NON-NLS-1$
	            response.getBody().getName());
	    Assertions.assertNull(response.getBody().getDescription());
    }

}
