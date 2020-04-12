package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.builders.RuleBuilder;
import com.kawa.api.commons.errors.builders.RuleSetBuilder;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.commons.errors.faces.IRules;

/**
 * <b>Rule Builder</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the {@link RuleBuilder}.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Rules >> Builder")
public final class RuleSetBuilderTests {

    /** Rule #1. */
    private static final IRule RULE_1 = new RuleBuilder()
            .appendCode("CODE_1") //$NON-NLS-1$
            .appendAssertion("ASSERTION_1") //$NON-NLS-1$
            .appendLevel(RequirementLevel.MUST)
            .build();

    /** Rule #2. */
    private static final IRule RULE_2 = new RuleBuilder()
            .appendCode("CODE_2") //$NON-NLS-1$
            .appendAssertion("ASSERTION_2") //$NON-NLS-1$
            .appendLevel(RequirementLevel.MUST_NOT)
            .build();

    /** Rule #3. */
    private static final IRule RULE_3 = new RuleBuilder()
            .appendCode("CODE_3") //$NON-NLS-1$
            .appendAssertion("ASSERTION_3") //$NON-NLS-1$
            .appendLevel(RequirementLevel.SHOULD)
            .build();

    /** Rule #4. */
    private static final IRule RULE_4 = new RuleBuilder()
            .appendCode("CODE_4") //$NON-NLS-1$
            .appendAssertion("ASSERTION_4") //$NON-NLS-1$
            .appendLevel(RequirementLevel.SHOULD_NOT)
            .build();

    /** Rule #5. */
    private static final IRule RULE_5 = new RuleBuilder()
            .appendCode("CODE_5") //$NON-NLS-1$
            .appendAssertion("ASSERTION_5") //$NON-NLS-1$
            .appendLevel(RequirementLevel.MAY)
            .build();

    /** Rule #6. */
    private static final IRule RULE_6 = new RuleBuilder()
            .appendCode("CODE_6") //$NON-NLS-1$
            .appendAssertion("ASSERTION_6") //$NON-NLS-1$
            .appendLevel(RequirementLevel.MAY)
            .build();

    /** NB Rules. */
    public static final int NB = 5;

    /**
     * Check the nominal case.
     * @since 0.1.0 hydrogen
     */
    @SuppressWarnings("static-method")
    @Test
    @DisplayName("Nominal Case")
    public void checkNominal() {

        final IRules rules = new RuleSetBuilder()
                .append(RULE_6)
                .reset()
                .append(RULE_1)
                .append(RULE_2.getCode(), RULE_2.getAssertion(),
                        RULE_2.getLevel())
                .append(RULE_3)
                .append(RULE_4.getCode(), RULE_4.getAssertion(),
                        RULE_4.getLevel())
                .append(' ' + RULE_5.getCode() + ' ',
                        ' ' + RULE_5.getAssertion() + ' ',
                        RULE_5.getLevel())
                .append(RULE_5)
                .append(null)
                .append(null, null, null)
                .build();

        Assertions.assertNotNull(rules.getAll());
        Assertions.assertEquals(rules.getAll().size(), NB + 1);

        Assertions.assertEquals(RULE_1, rules.get(RULE_1.getCode()));
        Assertions.assertEquals(RULE_2, rules.get(RULE_2.getCode()));
        Assertions.assertEquals(RULE_3, rules.get(RULE_3.getCode()));
        Assertions.assertEquals(RULE_4, rules.get(RULE_4.getCode()));
        Assertions.assertEquals(RULE_5, rules.get(RULE_5.getCode()));
        Assertions.assertEquals(new RuleBuilder().build(),
                rules.get(null));
        Assertions.assertEquals(new RuleBuilder().build(),
                rules.get(RULE_1.getCode() + 'A'));

        Assertions.assertNotEquals(rules.toString(),
                rules.getClass().getName() + '@'
                + Integer.toHexString(rules.hashCode()));

    }

}
