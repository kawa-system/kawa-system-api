package com.kawa.api.commons.errors.constants;

import com.kawa.api.commons.errors.enums.RequirementLevel;

/**
 * <b>Rule</b> Constants.
 * <br>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class RuleConstants {

    /** Default Code. */
    public static final String DEFAULT_CODE
        = "DFT-COD"; //$NON-NLS-1$
    /** Default Code. */
    public static final String DEFAULT_ASSERTION
        = "No given assertion."; //$NON-NLS-1$
    /** Default Requirement Level. */
    public static final RequirementLevel DEFAULT_LEVEL
        = RequirementLevel.UNKNOWN;

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private RuleConstants() {
        super();
    }

}
