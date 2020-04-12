package com.kawa.api.commons.errors.abstracts;

import com.kawa.api.constants.Constants;

/**
 * <b>Kawa</b> {@link Exception}.
 * <br>
 *
 * The purpose of this exception is to represents any kind of error related to
 * this project.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public abstract class AKawaException extends Exception {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /**
     * Constructor.
     * @param sMessage The message.
     *
     * @since 0.1.0 hydrogen
     */
    protected AKawaException(final String sMessage) {
        super(sMessage);
    }

    /**
     * Constructor.
     * @param sMessage The message.
     * @param oCause The cause.
     * @since 0.1.0 hydrogen
     */
    protected AKawaException(
            final String sMessage,
            final Throwable oCause) {
        super(sMessage, oCause);
    }

}
