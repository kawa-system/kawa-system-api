package com.kawa.api.models;

/**
 * ProjectModel.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
public final class Project {

    /**
     * <b>UUID</b>.
     * <br>
     * The purpose of this attribute is to identify, in a unique way, a project.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private final String uuid;

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

    /**
     * Constructor.
     *
     * @param sUuid Initial UUID.
     * @param sName Initial Name.
     * @param sDescription Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public Project(
            final String sUuid,
            final String sName,
            final String sDescription) {
        this.uuid = sUuid;
        this.name = sName;
        this.description = sDescription;
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
     * @param sName The new short name.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setName(final String sName) {
        this.name = sName;
    }


    /**
     * @param sDescription The new description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setDescription(final String sDescription) {
        this.description = sDescription;
    }

}
