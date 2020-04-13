package com.kawa.api.controller.projects.pojos;

import com.kawa.api.controller.projects.abstracts.AProject;
import com.kawa.api.model.projects.faces.IProject;

/** Project. */
public final class ProjectGet extends AProject {

    /** <b>UUID</b>. */
    private String uuid;

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    public ProjectGet() {
        super(null, null);
    }

    /**
     * Constructor.
     *
     * @param iProject Project.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public ProjectGet(
        final IProject iProject) {
        super(getName(iProject), getDescription(iProject));
        this.uuid = getSafe(getUUID(iProject));
    }

    /**
     * Used to retrieve the name.
     * @param iProject A given project.
     * @return A name.
     * @since 0.1.0 hydrogen
     */
    private static String getName(final IProject iProject) {
        if (iProject == null) {
            return null;
        }
        return iProject.getName();
    }

    /**
     * Used to retrieve the description.
     * @param iProject A given project.
     * @return A description.
     * @since 0.1.0 hydrogen
     */
    private static String getDescription(final IProject iProject) {
        if (iProject == null) {
            return null;
        }
        return iProject.getDescription();
    }

    /**
     * Used to retrieve the description.
     * @param iProject A given project.
     * @return A description.
     * @since 0.1.0 hydrogen
     */
    private static String getUUID(final IProject iProject) {
        if (iProject == null) {
            return null;
        }
        return iProject.getUuid();
    }

    /**
     * @return current UUID.
     * @since 0.1.0 hydrogen
     */
    public String getUUID() {
        return this.uuid;
    }

}
