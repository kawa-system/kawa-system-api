package com.kawa.api.commons.errors.abstracts;

import com.kawa.api.commons.errors.builders.RuleBuilder;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.constants.Constants;

/**
 * <b>Business</b> {@link Exception}.
 * <br>
 *
 * The purpose of this exception is to represents any kind of error related to
 * the violation of a business requirement that should be theoretically returned
 * to the caller.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public abstract class ABusinessException extends Exception {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /** Rule. */
    private final IRule rule;

    /**
     * Constructor.
     * @param sMessage The message.
     * @param sCode The violated rule's code.
     * @param sAssertion The violated rule's assertion.
     * @param oLevel The violated rule's level.
     *
     * @since 0.1.0 hydrogen
     */
    protected ABusinessException(
            final String sMessage,
            final String sCode,
            final String sAssertion,
            final RequirementLevel oLevel) {
        super(sMessage);
        this.rule = new RuleBuilder()
                .appendCode(sCode)
                .appendAssertion(sAssertion)
                .appendLevel(oLevel)
                .build();
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param iRule The violated rule.
     *
     * @since 0.1.0 hydrogen
     */
    protected ABusinessException(
            final String sMessage,
            final IRule iRule) {
        super(sMessage);
        this.rule = new RuleBuilder()
                .appendRule(iRule)
                .build();
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param sCode The violated rule's code.
     * @param sAssertion The violated rule's assertion.
     * @param oLevel The violated rule's level.
     * @param oCause The cause.
     *
     * @since 0.1.0 hydrogen
     */
    protected ABusinessException(
            final String sMessage,
            final String sCode,
            final String sAssertion,
            final RequirementLevel oLevel,
            final Throwable oCause) {
        super(sMessage, oCause);
        this.rule = new RuleBuilder()
                .appendCode(sCode)
                .appendAssertion(sAssertion)
                .appendLevel(oLevel)
                .build();
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param iRule The violated rule.
     * @param oCause The cause.
     *
     * @since 0.1.0 hydrogen
     */
    protected ABusinessException(
            final String sMessage,
            final IRule iRule,
            final Throwable oCause) {
        super(sMessage, oCause);
        this.rule = new RuleBuilder()
                .appendRule(iRule)
                .build();
    }

    /**
     * @return the business requirement violated.
     * @since 0.1.0 hydrogen
     */
    public final IRule getViolation() {
        return this.rule;
    }

}
