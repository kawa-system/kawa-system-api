package com.kawa.api.controller.projects.abstracts;

import org.apache.commons.lang3.StringUtils;
import org.owasp.encoder.Encode;

/**
 * Project Abstraction.
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public abstract class AProject {

    /** Short <b>Name</b>. */
    private String name;
    /** <b>Description</b>. */
    private String description;

    /**
     * Used to retrieve a safe value.
     * @param s the value.
     * @return A safe value.
     * @since 0.1.0 hydrogen
     */
    protected static String getSafe(final String s) {
        if (StringUtils.isBlank(s)) {
            return StringUtils.EMPTY;
        }
        return Encode.forJava(s.trim());
    }

    /**
     * Constructor.
     *
     * @param sName Initial Name.
     * @param sDescription Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public AProject(
        final String sName,
        final String sDescription) {
        this.name = getSafe(sName);
        this.description = getSafe(sDescription);
    }

    /**
     * @return current short name.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public final String getName() {
        return this.name;
    }

    /**
     * @return current UUID
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public final String getDescription() {
        return this.description;
    }

}
