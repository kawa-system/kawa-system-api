package com.kawa.api.model.projects.abstracts;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.builders.RuleSetBuilder;
import com.kawa.api.commons.errors.faces.IRules;
import com.kawa.api.constants.Constants;
import com.kawa.api.model.projects.constants.ProjectConstants;

/**
 * <b>Project</b> Business Exceptions.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 *
 * @version 0.1.0 hydrogen
 */
public abstract class AProjectException
    extends ABusinessException {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /** Business Rules. */
    private static final IRules RULES = new RuleSetBuilder()
            .append(ProjectConstants.RUL_NAME_REQUIRED)
            .append(ProjectConstants.RUL_NAME_MIN)
            .append(ProjectConstants.RUL_NAME_MAX)
            .append(ProjectConstants.RUL_DESC_MAX)
            .build();

    /**
     * Constructor.
     * @param sCode Code of the business rule violated.
     * @param sMessage Message.
     * @since 0.1.0 hydrogen
     */
    protected AProjectException(
            final String sCode,
            final String sMessage) {
        super(sMessage, RULES.get(sCode));
    }

}
