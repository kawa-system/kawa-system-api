package com.kawa.api.dto;

/**
 * ProjectDTO.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
public class ProjectDTO {

    /**
     * <b>UUID</b>.
     * <br>
     * The purpose of this attribute is to identify, in a unique way, a project.
     * <hr>
     * @since 0.1.0 hydrogen
     */
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

	public String getUuid() {
		return uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}