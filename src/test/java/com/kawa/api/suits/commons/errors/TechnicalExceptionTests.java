package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.constants.Constants;

/**
 * <b>Technical Exception</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the <code>class</code>
 * {@link ATechnicalException}.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Technical Exception")
public final class TechnicalExceptionTests {

    /** Message. */
    private static final String MSG_1 = "MESSAGE 1"; //$NON-NLS-1$

    /** Message. */
    private static final String MSG_2 = "MESSAGE 2"; //$NON-NLS-1$

    /**
     * Test {@link ATechnicalException} Constructors.
     */
    @Test
    @DisplayName("Constructors")
    @SuppressWarnings("static-method")
    public void checkConstructors() {
        final TestException test1 = new TestException(MSG_1);

        Assertions.assertEquals(MSG_1, test1.getMessage());
        Assertions.assertNull(test1.getCause());

        final TestException test2 = new TestException(MSG_2,
                new NullPointerException());

        Assertions.assertEquals(MSG_2, test2.getMessage());
        Assertions.assertNotNull(test2.getCause());
        Assertions.assertEquals(NullPointerException.class,
                test2.getCause().getClass());

    }

    /**
     * Generic Technical Exception for testing.
     * @author <a href="https://github.com/old-papa-bear">
     * Nicolas "P.B." ROLLE</a>
     * @version 0.1.0 hydrogen
     */
    private static final class TestException extends ATechnicalException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /**
         * Constructor.
         * @param sMessage The message.
         *
         * @since 0.1.0 hydrogen
         */
        protected TestException(final String sMessage) {
            super(sMessage);
        }

        /**
         * Constructor.
         * @param sMessage The message.
         * @param oCause The cause.
         * @since 0.1.0 hydrogen
         */
        protected TestException(
                final String sMessage,
                final Throwable oCause) {
            super(sMessage, oCause);
        }

    }

}
