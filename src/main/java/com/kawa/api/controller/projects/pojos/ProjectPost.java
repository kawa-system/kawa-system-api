package com.kawa.api.controller.projects.pojos;

import com.kawa.api.controller.projects.abstracts.AProject;

/**
 * Post Project.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class ProjectPost extends AProject {

    /**
     * Constructor.
     *
     * @param sName Initial Name.
     * @param sDescription Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public ProjectPost(
        final String sName,
        final String sDescription) {
        super(sName, sDescription);
    }

}
