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
 * Unit Test Class dedicated to check {@link KawaSystemApiApplication}.
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "Papa Bear" ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public final class KawaSystemApiApplicationTests {

    /** Local Server Port. */
    @LocalServerPort
    private int port;

    /** Rest Template. */
    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Unit Test used to validate {@link KawaSystemApiApplication#hello(String)}
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("[GET /hello] Nominal Case")
    public void testHello() throws Exception {
        /* Nominal Case : Default Name. */
        ResponseEntity<String> response = this.restTemplate.getForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/hello").toString(), String.class); //$NON-NLS-1$

        Assertions.assertEquals(200, response.getStatusCodeValue());
	    Assertions.assertEquals("Hello World!", //$NON-NLS-1$
	            response.getBody());

        /* Nominal Case : Test Name. */
	    response = this.restTemplate.getForEntity(
                new URL("http://localhost:" + this.port //$NON-NLS-1$
                        + "/hello?name=Test") //$NON-NLS-1$
                    .toString(), String.class);

        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals("Hello Test!", //$NON-NLS-1$
                response.getBody());
	}

}
