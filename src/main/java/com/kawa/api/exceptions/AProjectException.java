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
     * Constructor.
     * @param sMessage The message.
     * @param oCause The cause.
     * @since 0.1.0 hydrogen
     */
    protected AProjectException(final String sMessage, final Throwable oCause) {
        super(sMessage, oCause);
    }

    /**
     * Error : Project's UUDI is invalid !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's UUID is invalid !")
    public static final class InvalidUUID extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG_PFX = "The given UUID ["; //$NON-NLS-1$
        /** Message Suffix. */
        private static final String MSG_SFX =  "] is invalid."; //$NON-NLS-1$

        /**
         * Constructor.
         * @param sUUID Given UUID.
         * @param iae The cause.
         * @since 0.1.0 hydrogen
         */
        public InvalidUUID(
            final String sUUID,
            final IllegalArgumentException iae) {
            super(MSG_PFX + sUUID + MSG_SFX, iae);
        }

    }

    /**
     * Error : Project's UUDI is already used !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's UUID is already used !")
    public static final class UUIDUsed extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG_PFX = "The given UUID ["; //$NON-NLS-1$
        /** Message Suffix. */
        private static final String MSG_SFX =  "] is already used."; //$NON-NLS-1$

        /**
         * Constructor.
         * @param sUUID Given UUID.
         * @since 0.1.0 hydrogen
         */
        public UUIDUsed(final String sUUID) {
            super(MSG_PFX + sUUID + MSG_SFX);
        }

    }

    /**
     * Error : Project's Name is required !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's name is required !")
    public static final class NameRequired extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG = "The name's of a project is required"; //$NON-NLS-1$

        /**
         * Constructor.
         * @since 0.1.0 hydrogen
         */
        public NameRequired() {
            super(MSG);
        }
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
        private static final String MSG_PFX = "The name's size ["; //$NON-NLS-1$
        /** Message Suffix. */
        private static final String MSG_SFX = "]is too small for a project." //$NON-NLS-1$
            + " The minimum expected is [" + ProjectConstants.NAME_MINIMUM_SIZE //$NON-NLS-1$
            + "]"; //$NON-NLS-1$

        /**
         * Constructor.
         * @param iInvalidSize The invalid size.
         * @since 0.1.0 hydrogen
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
        private static final String MSG_PFX = "The name's size ["; //$NON-NLS-1$
        /** Message Suffix. */
        private static final String MSG_SFX = "]is too long for a project." //$NON-NLS-1$
            + " The maximum expected is [" + ProjectConstants.NAME_MAXIMUM_SIZE //$NON-NLS-1$
            + "]"; //$NON-NLS-1$

        /**
         * Constructor.
         * @param iInvalidSize The invalid size.
         * @since 0.1.0 hydrogen
         */
        public NameTooLong(final int iInvalidSize) {
            super(MSG_PFX + iInvalidSize + MSG_SFX);
        }
    }

    /**
     * Error : Project's Description is too long !
     * <hr>
     *
     * @since 0.1.0 hydrogen
     * @author Nicolas "Papa Bear" ROLLE
     */
    @ResponseStatus(
        code = HttpStatus.BAD_REQUEST,
        reason = "Project's description is too long !")
    public static final class DescriptionTooLong
        extends AProjectException {

        /** Serial Version Unique ID. */
        private static final long serialVersionUID = Constants.SUID;

        /** Message Prefix. */
        private static final String MSG_PFX = "The description's size ["; //$NON-NLS-1$
        /** Message Suffix. */
        private static final String MSG_SFX = "]is too long for a project." //$NON-NLS-1$
            + " The maximum expected is [" + Constants.DEFAULT_MAXIMUM_LENGTH //$NON-NLS-1$
            + "]"; //$NON-NLS-1$

        /**
         * Constructor.
         * @param iInvalidSize The invalid size.
         * @since 0.1.0 hydrogen
         */
        public DescriptionTooLong(final int iInvalidSize) {
            super(MSG_PFX + iInvalidSize + MSG_SFX);
        }
    }

}
