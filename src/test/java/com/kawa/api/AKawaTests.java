package com.kawa.api;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

/**
 * 
 * @author XaM
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public abstract class AKawaTests {

    /** Local Server Port. */
    @LocalServerPort
    protected int port;
	
    @BeforeAll
	public void setUp() { }
	
    @AfterAll
	public void tearDown() { } 
}
