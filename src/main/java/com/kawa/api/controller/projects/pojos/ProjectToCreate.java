package com.kawa.api.controller.projects.pojos;

import org.apache.commons.lang3.StringUtils;
import org.owasp.encoder.Encode;

/** Project. */
public final class ProjectToCreate {

    /** Short <b>Name</b>. */
    private String name;
    /** <b>Description</b>. */
    private String description;

    /**
     * Constructor.
     *
     * @param sName Initial Name.
     * @param sDescription Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public ProjectToCreate(
        final String sName,
        final String sDescription) {
        if (sName != null) {
            this.name = Encode.forJava(StringUtils.trim(sName));
        }
        if (sDescription != null) {
            this.description = Encode.forJava(StringUtils.trim(sDescription));
        } else {
            this.description = ""; //$NON-NLS-1$
        }
    }

    /**
     * @return current short name.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return current UUID
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public String getDescription() {
        return this.description;
    }

}
