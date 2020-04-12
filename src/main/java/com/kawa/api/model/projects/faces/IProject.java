package com.kawa.api.model.projects.faces;

import java.io.Serializable;

/**
 * <b>Project</b> <code>interface</code>.
 * <br>
 *
 * This <code>interface</code> represents a <b>project</b>.
 * <hr>
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 *
 */
public interface IProject
    extends Serializable, Comparable<IProject> {

    /**
     * @return the UUID.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    String getUuid();

    /**
     * @return the name.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    String getName();

    /**
     * @return the description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    String getDescription();

}
