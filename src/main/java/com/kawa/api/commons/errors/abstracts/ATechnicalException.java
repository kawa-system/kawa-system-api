package com.kawa.api.commons.errors.abstracts;

import com.kawa.api.constants.Constants;

/**
 * <b>Business</b> {@link Exception}.
 * <br>
 *
 * The purpose of this exception is to represents any kind of internal technical
 * error preventing the execution of a service.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public abstract class ATechnicalException extends AKawaException {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /**
     * Constructor.
     * @param sMessage The message.
     *
     * @since 0.1.0 hydrogen
     */
    protected ATechnicalException(final String sMessage) {
        super(sMessage);
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param oCause The cause.
     * @since 0.1.0 hydrogen
     */
    protected ATechnicalException(
            final String sMessage,
            final Throwable oCause) {
        super(sMessage, oCause);
    }

}
