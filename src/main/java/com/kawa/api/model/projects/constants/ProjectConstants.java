package com.kawa.api.model.projects.constants;

import com.kawa.api.commons.errors.builders.RuleBuilder;
import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.faces.IRule;
import com.kawa.api.constants.Constants;

/**
 * <b>Project</b> Constants <code>class</code>.
 * <br>
 *
 * The purpose of this <code>class</code> is to provide constant(s) dedicated to
 * {@link com.kawa.api.controller.projects.pojos.ProjectToCreate.Project}.
 * <hr>
 *
 * @version 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public final class ProjectConstants {

    /** Maximum number of project returned. */
    public static final int MAX_NB_PROJECT = 50;

    /** Name : Minimum Size. */
    public static final int NAME_MINIMUM_SIZE = 3;
    /** Name : Maximum Size. */
    public static final int NAME_MAXIMUM_SIZE = 40;

    /** Rule's Code : Name Required. */
    public static final String COD_NAME_REQUIRED
        = "PRJ_NAM_001"; //$NON-NLS-1$
    /** Rule's Code : Name Minimum Length. */
    public static final String COD_NAME_MIN
        = "PRJ_NAM_002"; //$NON-NLS-1$
    /** Rule's Code : Name Maximum Length. */
    public static final String COD_NAME_MAX
        = "PRJ_NAM_003"; //$NON-NLS-1$
    /** Rule's Code : Description Maximum Length. */
    public static final String COD_DESC_MAX
        = "PRJ_DSC_001"; //$NON-NLS-1$

    /** Rule's Assertion : Name Required. */
    public static final String AST_NAME_REQUIRED
        = "The name of a project SHALL NOT be blank."; //$NON-NLS-1$
    /** Rule's Assertion : Name Minimum Length. */
    public static final String AST_NAME_MIN
        = "The name of a project SHALL have a minimum length of [" //$NON-NLS-1$
        + NAME_MINIMUM_SIZE + "]."; //$NON-NLS-1$
    /** Rule's Assertion : Name Maximum Length. */
    public static final String AST_NAME_MAX
        = "The name of a project SHALL have a maximum length of [" //$NON-NLS-1$
        + NAME_MAXIMUM_SIZE + "]."; //$NON-NLS-1$
    /** Rule's Assertion : Description Maximum Length. */
    public static final String AST_DESC_MAX
        = "The name of a project SHALL have a maximum length of [" //$NON-NLS-1$
        + Constants.DEFAULT_MAXIMUM_LENGTH + "]."; //$NON-NLS-1$

    /** Rule - Project's Name : Required. */
    public static final IRule RUL_NAME_REQUIRED = new RuleBuilder()
            .appendCode(COD_NAME_REQUIRED)
            .appendAssertion(AST_NAME_REQUIRED)
            .appendLevel(RequirementLevel.MUST_NOT)
            .build();

    /** Rule - Project's Name : Minimum Size. */
    public static final IRule RUL_NAME_MIN = new RuleBuilder()
            .appendCode(COD_NAME_MIN)
            .appendAssertion(AST_NAME_MIN)
            .appendLevel(RequirementLevel.MUST)
            .build();

    /** Rule - Project's Name : Maximum Size. */
    public static final IRule RUL_NAME_MAX = new RuleBuilder()
            .appendCode(COD_NAME_MAX)
            .appendAssertion(AST_NAME_MAX)
            .appendLevel(RequirementLevel.MUST)
            .build();

    /** Rule - Project's Description : Maximum Size. */
    public static final IRule RUL_DESC_MAX = new RuleBuilder()
            .appendCode(COD_DESC_MAX)
            .appendAssertion(AST_DESC_MAX)
            .appendLevel(RequirementLevel.MUST)
            .build();

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private ProjectConstants() {
        super();
    }

}
