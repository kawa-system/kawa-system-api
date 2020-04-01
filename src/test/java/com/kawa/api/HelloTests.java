package com.kawa.api;

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
 * Unit Test Class dedicated to check {@link HelloController}.
 *
 * @author <a href="https://github.com/old-papa-bear">
 * Nicolas "Papa Bear" ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class HelloTests {

    /** HTTP Status Code : Success (200). */
    private static final int STATUS_SUCCESS = 200;

    /** Local Server Port. */
    @LocalServerPort
    private int port;

    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /** Name : Default. */
    private static final String NAME_DFT = "World"; //$NON-NLS-1$
    /** Name : Nominal. */
    private static final String NAME_NOM = "Jean Pierre"; //$NON-NLS-1$

    /** Result Prefix. */
    private static final String RES_PFX = "Hello"; //$NON-NLS-1$
    /** Result Suffix. */
    private static final String RES_SFX = "!"; //$NON-NLS-1$

    /**
     * Used to build an expected result.
     * @param sName The name given to the service.
     * @return The expected result.
     */
    private static String buildExpected(final String sName) {
        if (sName == null) {
            return buildExpected(NAME_DFT);
        }
        return RES_PFX + sName + RES_SFX;
    }

    /**
     * Unit Test used to validate {@link HelloController#hello(String)}.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[GET /hello] Nominal Case - Without name")
    public void testHelloWithoutName() throws Exception {
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/hello").toString(), String.class); //$NON-NLS-1$

        Assertions.assertEquals(STATUS_SUCCESS, response.getStatusCodeValue());
        Assertions.assertEquals(buildExpected(null), response.getBody());
    }

    /**
     * Unit Test used to validate {@link HelloController#hello(String)}.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[GET /hello] Nominal Case - With name")
    public void testHelloWithName() throws Exception {
    ResponseEntity<String> response = this.restTemplate.getForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/hello?name=" + NAME_NOM) //$NON-NLS-1$
                    .toString(), String.class);

        Assertions.assertEquals(STATUS_SUCCESS, response.getStatusCodeValue());
        Assertions.assertEquals(buildExpected(NAME_NOM),
                response.getBody());
    }

}
