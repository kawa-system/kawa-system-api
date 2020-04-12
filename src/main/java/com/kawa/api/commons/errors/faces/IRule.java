package com.kawa.api.commons.errors.faces;

import java.io.Serializable;

import com.kawa.api.commons.errors.enums.RequirementLevel;

/**
 * This <b>interface</b> represents a <b>rule</b>.
 * <br>
 *
 * A <b>rule</b> represents a requirement which should be supported. If violated
 * , could result to a warning or an error.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public interface IRule extends Serializable, Comparable<IRule> {

    /**
     * @return the rule's code.
     * @since 0.1.0 hydrogen
     */
    String getCode();

    /**
     * @return the rule's assertion.
     * @since 0.1.0 hydrogen
     */
    String getAssertion();

    /**
     * @return the requirement level of this rule.
     * @since 0.1.0 hydrogen
     */
    RequirementLevel getLevel();

}
