package com.kawa.api.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * ProjectModel.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@Document(collection = "projects")
public final class Project {

    /**
     * <b>UUID</b>.
     * <br>
     * The purpose of this attribute is to identify, in a unique way, a project.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    @Id
    private String uuid;

    /**
     * Short <b>Name</b>.
     * <br>
     * The purpose of this attribute is to identify a project through a <i>human
     * </i> understandable short text.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private String name;

    /**
     * <b>Description</b>.
     * <br>
     * The purpose of this attribute is to provide a descriptive text of the
     * project.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private String description;

    public Project() {}

    /**
     * Constructor.
     *
     * @param uuid Initial UUID.
     * @param name Initial Name.
     * @param description Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public Project(
            final String uuid,
            final String name,
            final String description) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
    }

    /**
     * @return current UUID
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public String getUuid() {
        return this.uuid;
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

    /**
     * @param uuid The UUID.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setUuid(final String uuid) {
        this.uuid = uuid;
    }

    /**
     * @param name The new short name.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setName(final String name) {
        this.name = name;
    }


    /**
     * @param description The new description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setDescription(final String description) {
        this.description = description;
    }

}
