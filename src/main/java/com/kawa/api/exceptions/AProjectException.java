package com.kawa.api.exceptions;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>Project</b> <code>abstract</code> {@link Exception}.
 * <br>
 *
 * The purpose of this exception is to represents any kind of error related to a
 * {@link com.kawa.api.models.Project}.
 * <hr>
 *
 * @version 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public abstract class AProjectException extends Exception {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /**
     * Constructor.
     * @param sMessage The message.
     *
     * @since 0.1.0 hydrogen
     */
    protected AProjectException(final String sMessage) {
        super(sMessage);
    }

    /**
     * Error : Project's Name is too small !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's name is too small !")
    public static final class NameTooSmall extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG_PFX = "The name's size [";
        /** Message Suffix. */
        private static final String MSG_SFX = "]is too small for a project."
            + " The minimum expected is [" + ProjectConstants.NAME_MINIMUM_SIZE
            + "]";

        /**
         * Constructor.
         * @param iInvalidSize The invalid size.
         * @since 0.1.0 hydrogn
         */
        public NameTooSmall(final int iInvalidSize) {
            super(MSG_PFX + iInvalidSize + MSG_SFX);
        }
    }

    /**
     * Error : Project's Name is too long !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's name is too long !")
    public static final class NameTooLong extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG_PFX = "The name's size [";
        /** Message Suffix. */
        private static final String MSG_SFX = "]is too long for a project."
            + " The maximum expected is [" + ProjectConstants.NAME_MAXIMUM_SIZE
            + "]";

        /**
         * Constructor.
         * @param iInvalidSize The invalid size.
         * @since 0.1.0 hydrogn
         */
        public NameTooLong(final int iInvalidSize) {
            super(MSG_PFX + iInvalidSize + MSG_SFX);
        }
    }

}
