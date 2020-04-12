package com.kawa.api.repositories;

import com.kawa.api.models.ProjectDTO;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <b>ProjectRepository</b> <code>interface</code>
 * {@link MongoRepository<ProjectDTO, String>}.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@Repository
public interface ProjectRepository extends MongoRepository<ProjectDTO, String> {

    /* Empty Interface. */

}
