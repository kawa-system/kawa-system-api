package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.builders.RuleBuilder;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.constants.Constants;

/**
 * <b>Business Exception</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the <code>class</code>
 * {@link ABusinessException}.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Business Exception")
public final class BusinessExceptionTests {

    /** Message. */
    private static final String MSG = "MESSAGE"; //$NON-NLS-1$
    /** Code. */
    private static final String CODE = "CODE"; //$NON-NLS-1$
    /** Assertion. */
    private static final String ASSERTION = "ASSERTION "; //$NON-NLS-1$
    /** Level. */
    private static final RequirementLevel LEVEL = RequirementLevel.MUST_NOT;

    /** Rule. */
    private static final IRule RULE = new RuleBuilder()
            .appendCode(CODE)
            .appendAssertion(ASSERTION)
            .appendLevel(LEVEL).build();

    /**
     * Test {@link ABusinessException} Constructors.
     */
    @Test
    @DisplayName("Constructors")
    @SuppressWarnings("static-method")
    public void checkConstructors() {

        final TestException test1 = new TestException(MSG, null);

        Assertions.assertEquals(test1.getMessage(), MSG);
        Assertions.assertNull(test1.getCause());
        Assertions.assertNotNull(test1.getViolation());
        Assertions.assertEquals(test1.getViolation(),
                new RuleBuilder().build());

        final TestException test2 = new TestException(MSG, RULE);

        Assertions.assertEquals(test2.getMessage(), MSG);
        Assertions.assertNull(test2.getCause());
        Assertions.assertNotNull(test2.getViolation());
        Assertions.assertEquals(test2.getViolation(), RULE);

        final TestException test3 = new TestException(MSG, RULE,
                new NullPointerException());

        Assertions.assertEquals(test3.getMessage(), MSG);
        Assertions.assertNotNull(test3.getCause());
        Assertions.assertNotNull(test3.getViolation());
        Assertions.assertEquals(test3.getCause().getClass(),
                NullPointerException.class);
        Assertions.assertEquals(test3.getViolation(), RULE);

        final TestException test4 = new TestException(MSG,
                CODE, ASSERTION, LEVEL);

        Assertions.assertEquals(test4.getMessage(), MSG);
        Assertions.assertNull(test4.getCause());
        Assertions.assertNotNull(test4.getViolation());
        Assertions.assertEquals(test4.getViolation(), RULE);

        final TestException test5 = new TestException(MSG,
                CODE, ASSERTION, LEVEL,
                new NullPointerException());

        Assertions.assertEquals(test5.getMessage(), MSG);
        Assertions.assertNotNull(test5.getCause());
        Assertions.assertNotNull(test5.getViolation());
        Assertions.assertEquals(test5.getCause().getClass(),
                NullPointerException.class);
        Assertions.assertEquals(test5.getViolation(), RULE);

    }

    /**
     * Generic Business Exception for testing.
     * @author <a href="https://github.com/old-papa-bear">
     * Nicolas "P.B." ROLLE</a>
     * @version 0.1.0 hydrogen
     */
    private static final class TestException extends ABusinessException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /**
         * Constructor.
         * @param sMessage The message.
         * @param iRule The rule.
         *
         * @since 0.1.0 hydrogen
         */
        protected TestException(final String sMessage, final IRule iRule) {
            super(sMessage, iRule);
        }

        /**
         * Constructor.
         * @param sMessage The message.
         * @param iRule The rule.
         * @param oCause The cause.
         * @since 0.1.0 hydrogen
         */
        protected TestException(
                final String sMessage,
                final IRule iRule,
                final Throwable oCause) {
            super(sMessage, iRule, oCause);
        }

        /**
         * Constructor.
         * @param sMessage The message.
         * @param sCode The code.
         * @param sAssertion The assertion.
         * @param oLevel The level.
         *
         * @since 0.1.0 hydrogen
         */
        protected TestException(
                final String sMessage,
                final String sCode,
                final String sAssertion,
                final RequirementLevel oLevel) {
            super(sMessage, sCode, sAssertion, oLevel);
        }

        /**
         * Constructor.
         * @param sMessage The message.
         * @param sCode The code.
         * @param sAssertion The assertion.
         * @param oLevel The level.
         * @param oCause The cause.
         *
         * @since 0.1.0 hydrogen
         */
        protected TestException(
                final String sMessage,
                final String sCode,
                final String sAssertion,
                final RequirementLevel oLevel,
                final Throwable oCause) {
            super(sMessage, sCode, sAssertion, oLevel, oCause);
        }

    }

}
