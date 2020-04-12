package com.kawa.api.commons.errors.faces;

import java.util.List;

/**
 * <b>Rule Set</b> <code>interface</code>.
 * <br>
 *
 * This <code>interface</code> represent a set of rules.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public interface IRules {

    /**
     * Used to retrieve a rule for a given code.
     * @param sCode The given code.
     * @return A rule.
     * @since 0.1.0 hydrogen
     */
    IRule get(String sCode);

    /**
     * Used to retrieve the list of rule in this set.
     * @return The list of rule.
     * @since 0.1.0 hydrogen
     */
    List<IRule> getAll();

}
