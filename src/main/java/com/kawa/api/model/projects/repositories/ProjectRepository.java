package com.kawa.api.model.projects.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kawa.api.model.projects.beans.ProjectBean;

/**
 * <b>ProjectRepository</b> <code>interface</code>
 * {@link MongoRepository<ProjectBean, String>}.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@Repository
public interface ProjectRepository
    extends MongoRepository<ProjectBean, String> {

    /* Empty Interface. */

}
