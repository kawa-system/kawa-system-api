package com.kawa.api.model.projects.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kawa.api.constants.Constants;
import com.kawa.api.model.projects.abstracts.AProjectException;
import com.kawa.api.model.projects.constants.ProjectConstants;

/**
 * <b>Project Name Required</b> {@link Exception}.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = ProjectConstants.AST_NAME_REQUIRED)
public final class ProjectNameRequired extends AProjectException {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    public ProjectNameRequired() {
        super(ProjectConstants.COD_NAME_REQUIRED,
                ProjectConstants.AST_NAME_REQUIRED);
    }

}
