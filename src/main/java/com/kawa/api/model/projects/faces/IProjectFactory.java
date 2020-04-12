package com.kawa.api.model.projects.faces;

import java.util.List;

import com.kawa.api.commons.errors.abstracts.ABusinessException;
import com.kawa.api.commons.errors.abstracts.ATechnicalException;

/**
 * <b>Project Factory</b> <code>interface</code>.
 * <br>
 *
 * This <code>interface</code> represents a class used to manage <b>projects</b>
 * .
 * <hr>
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 *
 */
public interface IProjectFactory {

    /**
     * Used to delete a project.
     * @param sUUID The uuid of the project.
     * @throws ABusinessException if a business requirement is violated.
     * @throws ATechnicalException if creation fail for technical reason.
     * @since 0.1.0 hydrogen
     */
    void delete(String sUUID)
            throws ABusinessException, ATechnicalException;

    /**
     * Used to create a new project.
     * @param sName The name of the project.
     * @param sDescription a description.
     * @return a new project.
     * @throws ABusinessException if a business requirement is violated.
     * @throws ATechnicalException if creation fail for technical reason.
     * @since 0.1.0 hydrogen
     */
    IProject create(
            String sName,
            String sDescription) throws ABusinessException, ATechnicalException;

    /**
     * @return all the projects.
     * @throws ABusinessException if a business requirement is violated.
     * @throws ATechnicalException if creation fail for technical reason.
     * @since 0.1.0 hydrogen
     */
    List<IProject> findAll() throws ABusinessException, ATechnicalException;
}
