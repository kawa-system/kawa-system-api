package com.kawa.api.model.projects.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kawa.api.constants.Constants;
import com.kawa.api.model.projects.abstracts.AProjectException;
import com.kawa.api.model.projects.constants.ProjectConstants;

/**
 * <b>Project Name Too Small</b> {@link Exception}.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = ProjectConstants.AST_NAME_MIN)
public final class ProjectNameTooSmall extends AProjectException {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /** Message Prefix. */
    private static final String MSG_PFX
        = "The given name's size is ["; //$NON-NLS-1$
    /** Message Suffix. */
    private static final String MSG_SFX
        = "]"; //$NON-NLS-1$

    /**
     * Constructor.
     * @param iSize The size of the project's name.
     * @since 0.1.0 hydrogen
     */
    public ProjectNameTooSmall(final int iSize) {
        super(ProjectConstants.COD_NAME_MIN, MSG_PFX + iSize + MSG_SFX);
    }

}
