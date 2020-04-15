package com.kawa.api.models;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.kawa.api.constants.Constants;
import com.kawa.api.constants.ProjectConstants;

/**
 * ProjectModel.
 *
 * @author <a href="https://github.com/fduquesne">Florian DUQUESNE</a>
 * @version 0.1.0 hydrogen
 */
@Document(collection = "projects")
public final class ProjectDTO implements Serializable, Comparable<ProjectDTO> {

    /** Serial Version Unique ID. */
    private static final long serialVersionUID = Constants.SUID;

    /** Hash Code : Initial Value. */
    private static final int HC_INIT = Constants.HC;
    /** Hash Code : Multiplier Value. */
    private static final int HC_MULT = ProjectConstants.HC;

    /** Field Name : UUID. */
    private static final String FLD_NAM_UUID = "uuid"; //$NON-NLS-1$
    /** Field Name : Name. */
    private static final String FLD_NAM_NAME = "name"; //$NON-NLS-1$

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

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    public ProjectDTO() {
        super();
    }

    /**
     * Constructor.
     *
     * @param sUuid Initial UUID.
     * @param sName Initial Name.
     * @param sDescription Initial Description.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public ProjectDTO(
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
     * @param sUuid The UUID.
     * <hr>
     * @since 0.1.0 hydrogen
     */
    public void setUuid(final String sUuid) {
        this.uuid = sUuid;
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

    @Override
    public int hashCode() {
        return new HashCodeBuilder(HC_INIT, HC_MULT)
                .append(this.uuid)
                .toHashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof ProjectDTO)) {
            return false;
        }
        return new EqualsBuilder()
                .append(this.uuid, ((ProjectDTO) o).uuid)
                .isEquals();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(FLD_NAM_UUID, this.uuid)
                .append(FLD_NAM_NAME, this.name)
                .toString();
    }

    @Override
    public int compareTo(final ProjectDTO o) {
        if (o == null) {
            return 1;
        }
        return StringUtils.compareIgnoreCase(this.name, o.name);
    }

}
