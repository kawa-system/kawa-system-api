/**
 * 
 */
package com.kawa.api.suits.projects;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import com.kawa.api.models.ProjectDTO;

/**
 * <b>Project D.T.O.</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the {@link ProjectDTO} one.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("[Project] >> [DTO]")
public final class ProjectDtoTests {

    /** Default ID. */
    private static final String DFT_ID = "default-id"; //$NON-NLS-1$
    /** Default Name. */
    private static final String DFT_NAME = "default-name"; //$NON-NLS-1$
    /** Default Description. */
    private static final String DFT_DESC = "default-description"; //$NON-NLS-1$

    /**
     * @return a new "void" instance.
     */
    private static ProjectDTO create() {
        final ProjectDTO oProject = new ProjectDTO();

        /* Attributes MUST be null when instantiate with void constructor. */
        Assertions.assertNull(oProject.getUuid(), "UUID MUST be " //$NON-NLS-1$
                + "null when instantiate with void constructor."); //$NON-NLS-1$
        Assertions.assertNull(oProject.getName(), "Name MUST be " //$NON-NLS-1$
                + "null when instantiate with void constructor."); //$NON-NLS-1$
        Assertions.assertNull(oProject.getDescription(),
                "Description MUST be " //$NON-NLS-1$
                + "null when instantiate with void constructor."); //$NON-NLS-1$

        return oProject;
    }

    /**
     * @param sUUID The unique user id.
     * @param sName The name.
     * @param sDescription The description.
     * @return a new instance.
     */
    private static ProjectDTO create(
            final String sUUID,
            final String sName,
            final String sDescription) {
        final ProjectDTO oProject = new ProjectDTO(sUUID, sName, sDescription);

        Assertions.assertEquals(sUUID, oProject.getUuid(),
                "UUID MUST be equals to the value used " //$NON-NLS-1$
                + "when instantiate with constructor."); //$NON-NLS-1$
        Assertions.assertEquals(sName, oProject.getName(),
                "UUID MUST be equals to the value used " //$NON-NLS-1$
                + "when instantiate with constructor."); //$NON-NLS-1$
        Assertions.assertEquals(sDescription, oProject.getDescription(),
                "Description MUST be equals to the value used " //$NON-NLS-1$
                + "when instantiate with constructor."); //$NON-NLS-1$

        return oProject;
    }

    /**
     * Used to check the method {@link ProjectDTO#setUuid(String)} of a
     * given instance.
     * @param oProject The given instance.
     */
    private static final void checkSetUuid(
            final ProjectDTO oProject) {
        Assertions.assertNotNull(oProject,
                "A Project CANNOT be null"); //$NON-NLS-1$

        /** Null Case. */
        oProject.setUuid(null);
        Assertions.assertNull(oProject.getUuid(),
                "UUID MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$
        /** Default Case. */
        oProject.setUuid(DFT_ID);
        Assertions.assertEquals(DFT_ID, oProject.getUuid(),
                "UUID MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$
    }

    /**
     * Used to check the method {@link ProjectDTO#setName(String)} of a
     * given instance.
     * @param oProject The given instance.
     */
    private static final void checkSetName(
            final ProjectDTO oProject) {
        Assertions.assertNotNull(oProject,
                "A Project CANNOT be null"); //$NON-NLS-1$

        /** Null Case. */
        oProject.setName(null);
        Assertions.assertNull(oProject.getName(),
                "Name MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$
        /** Default Case. */
        oProject.setName(DFT_NAME);
        Assertions.assertEquals(DFT_NAME, oProject.getName(),
                "Name MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$

    }

    /**
     * Used to check the method {@link ProjectDTO#setName(String)} of a
     * given instance.
     * @param oProject The given instance.
     */
    private static final void checkSetDescription(
            final ProjectDTO oProject) {
        Assertions.assertNotNull(oProject,
                "A Project CANNOT be null"); //$NON-NLS-1$

        /** Null Case. */
        oProject.setDescription(null);
        Assertions.assertNull(oProject.getDescription(),
                "Description MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$
        /** Default Case. */
        oProject.setDescription(DFT_DESC);
        Assertions.assertEquals(DFT_DESC, oProject.getDescription(),
                "Description MUST be equals to the value used " //$NON-NLS-1$
                + "through its setter."); //$NON-NLS-1$

    }

    /**
     * Test constructor, getter & setter for
     * {@link com.kawa.api.models.ProjectDTO}.
     */
    @SuppressWarnings({ "static-method", "unlikely-arg-type" })
    @Test
    @DisplayName("Constructor / Getters / Setters")
    @Timeout(unit = TimeUnit.MILLISECONDS, value = 50)
    final void test() {
        /** Create a new "void" instance. */
        final ProjectDTO voidProject = create();
        /** Create a new "null" instance. */
        final ProjectDTO nullProject = create(null, null, null);
        /** Create a new "default" instance. */
        final ProjectDTO defaultProject = create(DFT_ID, DFT_NAME, DFT_DESC);

        Assertions.assertFalse(nullProject.equals(null),
                "A project MUST NOT be equals to a null " //$NON-NLS-1$
                + "instance."); //$NON-NLS-1$
        Assertions.assertTrue(nullProject.equals(voidProject),
                "A void project MUST NOT be equals to a " //$NON-NLS-1$
                + "project initialized with null values."); //$NON-NLS-1$
        Assertions.assertFalse(voidProject.equals(defaultProject),
                "A void project MUST NOT be equals to a " //$NON-NLS-1$
                + "project initialized with null values."); //$NON-NLS-1$
        Assertions.assertFalse(defaultProject.equals(null),
                "A project MUST NOT be equals to a null " //$NON-NLS-1$
                + "instance."); //$NON-NLS-1$
        Assertions.assertTrue(defaultProject.equals(defaultProject),
                "A project MUST be equals to himself."); //$NON-NLS-1$
        Assertions.assertTrue(defaultProject.equals(
                new ProjectDTO(DFT_ID, null,  null)),
                "A project MUST be equals to another one " //$NON-NLS-1$
                + "with the same UUID."); //$NON-NLS-1$
        Assertions.assertFalse(defaultProject.equals(DFT_ID),
                "A project MUST NOT be equals to a String."); //$NON-NLS-1$

        Assertions.assertEquals(1, nullProject.compareTo(null));
        Assertions.assertEquals(-1, nullProject.compareTo(defaultProject));
        Assertions.assertEquals(1, defaultProject.compareTo(voidProject));
        Assertions.assertEquals(0, voidProject.compareTo(nullProject));
        Assertions.assertEquals(0, defaultProject.compareTo(
                create(null, DFT_NAME.toUpperCase(), null)));

        /* Check Setters. */
        checkSetUuid(voidProject);
        checkSetName(voidProject);
        checkSetDescription(voidProject);
        checkSetUuid(nullProject);
        checkSetName(nullProject);
        checkSetDescription(nullProject);
        checkSetUuid(defaultProject);
        checkSetName(defaultProject);
        checkSetDescription(defaultProject);

        Assertions.assertNotEquals(defaultProject.toString(),
                defaultProject.getClass().getName() + '@'
                + Integer.toHexString(defaultProject.hashCode()));

    }

}
