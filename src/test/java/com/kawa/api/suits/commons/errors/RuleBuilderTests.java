package com.kawa.api.suits.commons.errors;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.builders.RuleBuilder;
import com.kawa.api.commons.errors.constants.RuleConstants;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;

/**
 * <b>Rule Builder</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the {@link RuleBuilder}.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Rule >> Builder")
public final class RuleBuilderTests {

    /** Default Value : Code. */
    private static final String DFT_COD = "DFT-COD"; //$NON-NLS-1$
    /** Default Value : Assertion. */
    private static final String DFT_AST = "DFT-AST"; //$NON-NLS-1$
    /** Default Value : Requirement Level. */
    private static final RequirementLevel DFT_LVL
        = RequirementLevel.SHOULD;

    /**
     * Test a {@link IRule} instance.
     * @param iRule The rule to check.
     * @param sExpectedCode The expected code.
     * @param sExpectedAssertion The expected assertion.
     * @param oExpectedLevel The expected level.
     */
    @SuppressWarnings("static-method")
    private void check(
            final IRule iRule,
            final String sExpectedCode,
            final String sExpectedAssertion,
            final RequirementLevel oExpectedLevel) {
        Assertions.assertNotNull(iRule,
                "A Rule SHALL NOT be null."); //$NON-NLS-1$

        Assertions.assertTrue(
                StringUtils.isNotBlank(iRule.getCode()),
                "A Rule's Code SHALL NOT be blank."); //$NON-NLS-1$
        Assertions.assertEquals(sExpectedCode, iRule.getCode());

        Assertions.assertTrue(
                StringUtils.isNotBlank(iRule.getAssertion()),
                "A Rule's Assertion SHALL NOT be blank."); //$NON-NLS-1$
        Assertions.assertEquals(sExpectedAssertion, iRule.getAssertion());

        Assertions.assertNotNull(iRule.getLevel(),
                "A Rule's Level SHALL NOT be null"); //$NON-NLS-1$
        Assertions.assertEquals(oExpectedLevel, iRule.getLevel());


        Assertions.assertNotEquals(iRule.toString(),
                iRule.getClass().getName() + '@'
                + Integer.toHexString(iRule.hashCode()));
    }

    /**
     * Check the nominal case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Nominal Case")
    public void checkNominal() {
        final IRule iRule = new RuleBuilder()
                .appendCode(DFT_COD)
                .appendAssertion(DFT_AST)
                .appendLevel(DFT_LVL)
                .build();

        check(iRule, DFT_COD, DFT_AST, DFT_LVL);

        final IRule iRule2 = new RuleBuilder()
                .appendRule(iRule)
                .build();

        check(iRule2, DFT_COD, DFT_AST, DFT_LVL);
    }

    /**
     * Check the nominal case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Empty Cases")
    public void checkEmpty() {
        final IRule iRule = new RuleBuilder()
                .build();

        check(iRule, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

        final IRule iRule2 = new RuleBuilder()
                .appendCode(DFT_COD)
                .appendAssertion(DFT_AST)
                .appendLevel(DFT_LVL)
                .appendRule(null)
                .build();

        check(iRule2, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

        final IRule iRule3 = new RuleBuilder()
                .appendCode(DFT_COD)
                .appendAssertion(DFT_AST)
                .appendLevel(DFT_LVL)
                .appendRule(iRule2)
                .build();

        check(iRule3, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);
    }

    /**
     * Check the nominal case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Reset Cases")
    public void checkReset() {

        final IRule iDefault = new RuleBuilder()
                .appendCode(DFT_COD)
                .appendAssertion(DFT_AST)
                .appendLevel(DFT_LVL)
                .build();

        final IRule iRule = new RuleBuilder()
                .reset()
                .build();

        check(iRule, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

        final IRule iRule2 = new RuleBuilder()
                .appendCode(DFT_COD)
                .appendAssertion(DFT_AST)
                .appendLevel(DFT_LVL)
                .reset()
                .build();

        check(iRule2, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

        final IRule iRule3 = new RuleBuilder()
                .appendRule(iDefault)
                .reset()
                .build();

        check(iRule3, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);
    }

    /**
     * Check the not nominal case.
     * @since 0.1.0 hydrogen
     */
    @Test
    @DisplayName("Not Nominal Case")
    public void checkNotNominal() {
        final IRule iRule = new RuleBuilder()
                .appendCode(' ' + DFT_COD + ' ')
                .appendAssertion(' ' + DFT_AST + ' ')
                .appendLevel(null)
                .build();

        check(iRule, DFT_COD, DFT_AST, RuleConstants.DEFAULT_LEVEL);

        final IRule iRule2 = new RuleBuilder()
                .appendCode(null)
                .appendAssertion(null)
                .appendLevel(null)
                .build();

        check(iRule2, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

        final String blankString = "            "; //$NON-NLS-1$
        final IRule iRule3 = new RuleBuilder()
                .appendCode(blankString)
                .appendAssertion(blankString)
                .appendLevel(null)
                .build();

        check(iRule3, RuleConstants.DEFAULT_CODE,
                RuleConstants.DEFAULT_ASSERTION,
                RuleConstants.DEFAULT_LEVEL);

    }

    /**
     * Check comparison.
     * @since 0.1.0 hydrogen
     */
    @SuppressWarnings("static-method")
    @Test
    @DisplayName("Comparison")
    public void checkComparison() {
        final IRule iRule1 = new RuleBuilder()
                .appendCode("CODE1") //$NON-NLS-1$
                .appendAssertion("#1") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule2 = new RuleBuilder()
                .appendCode("CODE2") //$NON-NLS-1$
                .appendAssertion("#2") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule3 = new RuleBuilder()
                .appendCode("code2") //$NON-NLS-1$
                .appendAssertion("#2") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD_NOT)
                .build();

        final IRule iRule4 = new RuleBuilder()
                .appendCode("CODE3") //$NON-NLS-1$
                .appendAssertion("#3") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD_NOT)
                .build();

        final IRule iRule5 = new RuleBuilder()
                .appendCode("code5") //$NON-NLS-1$
                .appendAssertion("#4") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD_NOT)
                .build();

        final IRule iRule6 = new RuleBuilder()
                .appendCode("  CODE5  ") //$NON-NLS-1$
                .appendAssertion("#4") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD)
                .build();

        final IRule iRule7 = new RuleBuilder()
                .appendCode("CODE004") //$NON-NLS-1$
                .appendAssertion("#5") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD)
                .build();

        Assertions.assertTrue(iRule1.compareTo(null) > 0);
        Assertions.assertTrue(iRule2.compareTo(iRule1) > 0);
        Assertions.assertEquals(0, iRule3.compareTo(iRule2));
        Assertions.assertTrue(iRule4.compareTo(iRule3) > 0);
        Assertions.assertTrue(iRule5.compareTo(iRule4) > 0);
        Assertions.assertEquals(0, iRule6.compareTo(iRule5));
        Assertions.assertTrue(iRule7.compareTo(iRule6) < 0);
        Assertions.assertEquals(0, iRule7.compareTo(iRule7));
        Assertions.assertTrue(iRule6.compareTo(iRule7) > 0);
        Assertions.assertEquals(0, iRule5.compareTo(iRule6));
        Assertions.assertTrue(iRule4.compareTo(iRule5) < 0);
        Assertions.assertTrue(iRule3.compareTo(iRule4) < 0);
        Assertions.assertEquals(0, iRule2.compareTo(iRule3));
        Assertions.assertTrue(iRule1.compareTo(iRule2) < 0);

    }

    /**
     * Check comparison.
     * @since 0.1.0 hydrogen
     */
    @SuppressWarnings({ "static-method", "unlikely-arg-type" })
    @Test
    @DisplayName("Equals")
    public void checkEquals() {
        final IRule iRule1A = new RuleBuilder()
                .appendCode("CODE") //$NON-NLS-1$
                .appendAssertion("#1A") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule1B = new RuleBuilder()
                .appendCode("CODE") //$NON-NLS-1$
                .appendAssertion("#1A") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule1C = new RuleBuilder()
                .appendCode("   CODE   ") //$NON-NLS-1$
                .appendAssertion("   #1A   ") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule2 = new RuleBuilder()
                .appendCode("code") //$NON-NLS-1$
                .appendAssertion("#2") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule3 = new RuleBuilder()
                .appendCode("CODE") //$NON-NLS-1$
                .appendAssertion("#1a") //$NON-NLS-1$
                .appendLevel(RequirementLevel.MAY)
                .build();

        final IRule iRule4 = new RuleBuilder()
                .appendCode("CODE") //$NON-NLS-1$
                .appendAssertion("#1A") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD_NOT)
                .build();

        final IRule iRule5A = new RuleBuilder().build();

        final IRule iRule5B = new RuleBuilder()
                .appendCode("CODE") //$NON-NLS-1$
                .appendAssertion("#1A") //$NON-NLS-1$
                .appendLevel(RequirementLevel.SHOULD_NOT)
                .reset()
                .build();

        final IRule iRule5C = new RuleBuilder()
                .appendCode(RuleConstants.DEFAULT_CODE)
                .appendAssertion(RuleConstants.DEFAULT_ASSERTION)
                .appendLevel(RuleConstants.DEFAULT_LEVEL)
                .build();

        final IRule iRule5D = new RuleBuilder()
                .appendCode("     ") //$NON-NLS-1$
                .appendAssertion("    ") //$NON-NLS-1$
                .appendLevel(null)
                .build();

        Assertions.assertFalse(iRule1A.equals(null));
        Assertions.assertFalse(iRule1A.equals(RuleConstants.DEFAULT_CODE));
        Assertions.assertTrue(iRule1A.equals(iRule1B));
        Assertions.assertTrue(iRule1B.equals(iRule1C));
        Assertions.assertTrue(iRule1A.equals(iRule1C));
        Assertions.assertFalse(iRule2.equals(iRule1A));
        Assertions.assertFalse(iRule2.equals(iRule1B));
        Assertions.assertFalse(iRule2.equals(iRule1C));
        Assertions.assertFalse(iRule1A.equals(iRule2));
        Assertions.assertFalse(iRule1B.equals(iRule2));
        Assertions.assertFalse(iRule1C.equals(iRule2));
        Assertions.assertFalse(iRule3.equals(iRule1A));
        Assertions.assertFalse(iRule4.equals(iRule1A));
        Assertions.assertFalse(iRule5A.equals(iRule1A));
        Assertions.assertTrue(iRule5A.equals(iRule5B));
        Assertions.assertTrue(iRule5B.equals(iRule5A));
        Assertions.assertTrue(iRule5C.equals(iRule5B));
        Assertions.assertTrue(iRule5D.equals(iRule5C));
        Assertions.assertTrue(iRule5D.equals(iRule5A));
    }

}
