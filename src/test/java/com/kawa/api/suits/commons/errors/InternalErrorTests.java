package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.exceptions.InternalErrorException;

/**
 * <b>Internal Error Exception</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the <code>class</code>
 * {@link InternalErrorException}.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Generic Internal Error Exception")
public final class InternalErrorTests {

    /** Message. */
    private static final String MSG_1 = "MESSAGE 1"; //$NON-NLS-1$

    /** Message. */
    private static final String MSG_2 = "MESSAGE 2"; //$NON-NLS-1$

    /**
     * Test {@link InternalErrorException} Constructors.
     */
    @Test
    @DisplayName("Constructors")
    @SuppressWarnings("static-method")
    public void checkConstructors() {
        final InternalErrorException test1 = new InternalErrorException(MSG_1);

        Assertions.assertEquals(test1.getMessage(), MSG_1);
        Assertions.assertNull(test1.getCause());

        final InternalErrorException test2 = new InternalErrorException(MSG_2,
                new NullPointerException());

        Assertions.assertEquals(test2.getMessage(), MSG_2);
        Assertions.assertNotNull(test2.getCause());
        Assertions.assertEquals(test2.getCause().getClass(),
                NullPointerException.class);

    }

}
