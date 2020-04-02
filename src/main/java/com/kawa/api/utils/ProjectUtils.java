package com.kawa.api.utils;

import com.kawa.api.exceptions.AProjectException.NameTooSmall;
import com.kawa.api.exceptions.AProjectException.UUIDUsed;
import com.kawa.api.models.Project;

import org.owasp.encoder.Encode;

import java.util.UUID;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;
import com.kawa.api.exceptions.AProjectException;
import com.kawa.api.exceptions.AProjectException.DescriptionTooLong;
import com.kawa.api.exceptions.AProjectException.InvalidUUID;
import com.kawa.api.exceptions.AProjectException.NameRequired;
import com.kawa.api.exceptions.AProjectException.NameTooLong;


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
     * Used to check & clean a given project candidate to a creation.
     * @param oProject The candidate.
     * @return A valid & clean project.
     * @throws AProjectException if, at least, one requirement is violated.
     */
    public static Project checkProjectToCreate(
        final Project oProject)
        throws AProjectException {

        if (oProject == null) {
            throw new AProjectException.ProjectRequired();
        }

        return new Project(
            checkUuidToCreate(oProject.getUuid()),
            checkName(oProject.getName()),
            checkDescription(oProject.getDescription()));

    }

    /**
     * Used to check a given project's UUID for creation.
     * @param sCandidateUUID The given project's UUID for creation.
     * @return A valid UUID.
     * @throws InvalidUUID if the given UUID is invalid.
     * @throws UUIDUsed if the given UUID is already used.
     */
    private static String checkUuidToCreate(
        final String sCandidateUUID)
        throws InvalidUUID, UUIDUsed {
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

        /* @TODO CHECK IF ALREADY EXISTS. */

        return oCandidate.toString();
    }

    /**
     * Used to check a given project's name.
     * @param sCandidateName The given project's name.
     * @return A valid name.
     * @throws NameRequired if the given {@link Project} got a null name.
     * @throws NameTooSmall if the given {@link Project} got a name too small.
     * @throws NameTooLong if the given {@link Project} got a name too long.
     */
    private static String checkName(
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
     * @throws DescriptionTooLong if the given {@link Project} got a description
     * too long.
     */
    private static String checkDescription(
        final String sCandidateDescription)
        throws DescriptionTooLong {

        if (sCandidateDescription == null) {
            return "";
        }

        final String sTrimmed = Encode.forJava(sCandidateDescription).trim();

        if (sTrimmed.length() > Constants.DEFAULT_MAXIMUM_LENGTH) {
            throw new DescriptionTooLong(sTrimmed.length());
        }
        return sTrimmed;
    }

}
