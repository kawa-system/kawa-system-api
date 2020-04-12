package com.kawa.api.commons.errors.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.ObjectUtils;
import org.modelmapper.internal.util.ToStringBuilder;

import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.commons.errors.faces.IRules;

/**
 * <b>Rule Set</b> builder.
 * <br>
 *
 * The purpose of this class is to build new instance of {@link IRules}.
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class RuleSetBuilder {

    /** Map of rules. */
    private final Map<String, IRule> rules;

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    public RuleSetBuilder() {
        super();
        this.rules = new HashMap<>();
    }

    /**
     * Used to reset this builder.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleSetBuilder reset() {
        this.rules.clear();
        return this;
    }

    /**
     * Used to append a rule.
     * @param sCode The given code.
     * @param sAssertion The given assertion.
     * @param oLevel The given level.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleSetBuilder append(
            final String sCode,
            final String sAssertion,
            final RequirementLevel oLevel) {

        final IRule iRule = new RuleBuilder()
                .appendCode(sCode)
                .appendAssertion(sAssertion)
                .appendLevel(oLevel)
                .build();

        this.rules.put(iRule.getCode(), iRule);

        return this;
    }

    /**
     * Used to append a rule.
     * @param iRule The given rule.
     * @return this builder.
     * @since 0.1.0 hydrogen
     */
    public RuleSetBuilder append(final IRule iRule) {
        if (iRule == null) {
            return this;
        }
        return append(iRule.getCode(),
                iRule.getAssertion(),
                iRule.getLevel());
    }

    /**
     * @return a new rule.
     * @since 0.1.0 hydrogen
     */
    public IRules build() {
        return new Rules(this.rules);
    }

    /**
     * Rule Set Implementation.
     *
     * @author <a href="https://github.com/old-papa-bear">
     * Nicolas "P.B." ROLLE</a>
     *
     * @version 0.1.0 hydrogen
     */
    private static final class Rules implements IRules {

        /** String Representation : Size. */
        private static final String SR_SIZE = "size"; //$NON-NLS-1$
        /** Default Rule. */
        private static final IRule DEFAULT = new RuleBuilder().build();

        /** Rules. */
        private final Map<String, IRule> rules;

        /**
         * Constructor.
         * @param oRules The rules.
         * @since 0.1.0 hydrogen
         */
        private Rules(final Map<String, IRule> oRules) {
            this.rules = oRules;
        }

        @Override
        public String toString() {
            return new ToStringBuilder(IRules.class)
                    .add(SR_SIZE, String.valueOf(this.rules.size()))
                    .toString();
        }

        @Override
        public IRule get(final String sCode) {
            if (sCode == null) {
                return DEFAULT;
            }
            return ObjectUtils.defaultIfNull(
                    this.rules.get(sCode),
                    DEFAULT);
        }

        @Override
        public List<IRule> getAll() {
            return new ArrayList<>(this.rules.values());
        }

    }

}
