package com.kawa.api.commons.errors.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kawa.api.commons.errors.abstracts.ATechnicalException;
import com.kawa.api.constants.Constants;

/**
 * Generic Internal Error {@link Exception}.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@ResponseStatus(
        code = HttpStatus.INTERNAL_SERVER_ERROR,
        reason = "Internal Server Error.")
public final class InternalErrorException extends ATechnicalException {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /**
     * Constructor.
     * @param sMessage The message.
     *
     * @since 0.1.0 hydrogen
     */
    public InternalErrorException(final String sMessage) {
        super(sMessage);
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param oCause The cause.
     * @since 0.1.0 hydrogen
     */
    public InternalErrorException(
            final String sMessage,
            final Throwable oCause) {
        super(sMessage, oCause);
    }

}
