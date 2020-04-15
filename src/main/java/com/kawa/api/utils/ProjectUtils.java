package com.kawa.api.utils;

import java.util.UUID;

import org.owasp.encoder.Encode;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;
import com.kawa.api.exceptions.AProjectException.DescriptionTooLong;
import com.kawa.api.exceptions.AProjectException.InvalidUUID;
import com.kawa.api.exceptions.AProjectException.NameRequired;
import com.kawa.api.exceptions.AProjectException.NameTooLong;
import com.kawa.api.exceptions.AProjectException.NameTooSmall;


/**
 * <b>Project</b> Utilities.
 * <br>
 *
 * The purpose of this <code>class</code> is to provide <code>static</code>
 * utilities dedicated to the <b>{@link com.kawa.api.models.Project}</b>
 * entities.
 * <hr>
 *
 * @since 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public final class ProjectUtils {

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static methods
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private ProjectUtils() {
        super();
    }

    /**
     * Used to check a given project's UUID for creation.
     * @param sCandidateUUID The given project's UUID for creation.
     * @return A valid UUID.
     * @throws InvalidUUID if the given UUID is invalid.
     */
    public static String checkUuidToCreate(
        final String sCandidateUUID)
        throws InvalidUUID {
        final UUID oCandidate;

        if (sCandidateUUID == null) {
            oCandidate = UUID.randomUUID();
        } else {

            try {
                oCandidate = UUID.fromString(Encode.forJava(sCandidateUUID));
            } catch (IllegalArgumentException iae) {
                throw new InvalidUUID(sCandidateUUID, iae);
            }
        }

        return oCandidate.toString();
    }

    /**
     * Used to check a given project's name.
     * @param sCandidateName The given project's name.
     * @return A valid name.
     * @throws NameRequired if the given name is null.
     * @throws NameTooSmall if the given name  is too small.
     * @throws NameTooLong if the given name is too long.
     */
    public static String checkName(
        final String sCandidateName)
        throws NameRequired, NameTooSmall, NameTooLong {

        if (sCandidateName == null) {
            throw new NameRequired();
        }

       final String sTrimmed = Encode.forJava(sCandidateName).trim();

        if (sTrimmed.length() < ProjectConstants.NAME_MINIMUM_SIZE) {
            throw new NameTooSmall(sTrimmed.length());
        }
        if (sTrimmed.length() > ProjectConstants.NAME_MAXIMUM_SIZE) {
            throw new NameTooLong(sTrimmed.length());
        }
        return sTrimmed;
    }

    /**
     * Used to check a given project's description.
     * @param sCandidateDescription The given project's description.
     * @return A valid description.
     * @throws DescriptionTooLong if the given description is too long.
     * too long.
     */
    public static String checkDescription(
        final String sCandidateDescription)
        throws DescriptionTooLong {

        if (sCandidateDescription == null) {
            return ""; //$NON-NLS-1$
        }

        final String sTrimmed = Encode.forJava(sCandidateDescription).trim();

        if (sTrimmed.length() > Constants.DEFAULT_MAXIMUM_LENGTH) {
            throw new DescriptionTooLong(sTrimmed.length());
        }
        return sTrimmed;
    }

}
