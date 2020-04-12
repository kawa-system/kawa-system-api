package com.kawa.api.commons.errors.builders;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.modelmapper.internal.util.ToStringBuilder;

import com.kawa.api.commons.errors.constants.RuleConstants;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.constants.Constants;
import com.kawa.api.constants.HCConstants;

/**
 * <b>Rule</b> builder.
 * <br>
 *
 * The purpose of this class is to build new instance of {@link IRule}.
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class RuleBuilder {

    /** Code. */
    private String code = RuleConstants.DEFAULT_CODE;
    /** Code. */
    private String assertion = RuleConstants.DEFAULT_ASSERTION;
    /** Level. */
    private RequirementLevel level = RuleConstants.DEFAULT_LEVEL;

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder() {
        super();
    }

    /**
     * Used to reset this builder.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder reset() {
        this.code = RuleConstants.DEFAULT_CODE;
        this.assertion = RuleConstants.DEFAULT_ASSERTION;
        this.level = RuleConstants.DEFAULT_LEVEL;
        return this;
    }

    /**
     * Used to append a given code.
     * @param sCode The given code.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder appendCode(final String sCode) {
        if (StringUtils.isNotBlank(sCode)) {
            this.code = sCode.trim();
        }
        return this;
    }

    /**
     * Used to append a given assertion.
     * @param sAssertion The given assertion.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder appendAssertion(final String sAssertion) {
        if (StringUtils.isNotBlank(sAssertion)) {
            this.assertion = sAssertion.trim();
        }
        return this;
    }

    /**
     * Used to append a given level.
     * @param oLevel The given level.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder appendLevel(final RequirementLevel oLevel) {
        if (oLevel != null) {
            this.level = oLevel;
        }
        return this;
    }

    /**
     * Used to append a rule.
     * @param iRule The given rule.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleBuilder appendRule(final IRule iRule) {
        if (iRule == null) {
            return reset();
        }
        return appendCode(iRule.getCode())
                .appendAssertion(iRule.getAssertion())
                .appendLevel(iRule.getLevel());
    }

    /**
     * @return a new rule.
     * @since 0.1.0 hydrogen
     */
    public IRule build() {
        return new Rule(this.code, this.assertion, this.level);
    }

    /**
     * Rule Implementation.
     *
     * @author <a href="https://github.com/old-papa-bear">
     * Nicolas "P.B." ROLLE</a>
     *
     * @version 0.1.0 hydrogen
     */
    private static final class Rule implements IRule {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Field Name : Code. */
        private static final String FLD_NAM_COD = "code"; //$NON-NLS-1$
        /** Field Name : Assertion. */
        private static final String FLD_NAM_AST = "assertion"; //$NON-NLS-1$
        /** Field Name : Requirement Level. */
        private static final String FLD_NAM_LVL = "level"; //$NON-NLS-1$

        /** Code. */
        private final String code;
        /** Assertion. */
        private final String assertion;
        /** Requirement Level. */
        private RequirementLevel level;

        /**
         * Constructor.
         * @param sCode initial code.
         * @param sAssertion initial assertion.
         * @param oLevel initial level.
         * @since 0.1.0 hydrogen
         */
        private Rule(
                final String sCode,
                final String sAssertion,
                final RequirementLevel oLevel) {
            this.code = sCode;
            this.assertion = sAssertion;
            this.level = oLevel;
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(HCConstants.HC_INIT,
                    HCConstants.HC_MLT_FAC_RULE)
                    .append(this.level)
                    .toHashCode();
        }

        @Override
        public boolean equals(final Object o) {
            final IRule iRule;

            if (o == null) {
                return false;
            }
            if (!(o instanceof IRule)) {
                return false;
            }

            iRule = (IRule) o;

            return new EqualsBuilder()
                    .append(this.assertion, iRule.getAssertion())
                    .append(this.code, iRule.getCode())
                    .append(this.level, iRule.getLevel())
                    .isEquals();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(IRule.class)
                    .add(FLD_NAM_COD, this.code)
                    .add(FLD_NAM_AST, this.assertion)
                    .add(FLD_NAM_LVL, this.level)
                    .toString();
        }

        @Override
        public int compareTo(final IRule iRule) {
            if (iRule == null) {
                return 1;
            }
            return StringUtils.compareIgnoreCase(this.code, iRule.getCode());
        }

        @Override
        public String getCode() {
            return this.code;
        }

        @Override
        public String getAssertion() {
            return this.assertion;
        }

        @Override
        public RequirementLevel getLevel() {
            return this.level;
        }

    }

}
