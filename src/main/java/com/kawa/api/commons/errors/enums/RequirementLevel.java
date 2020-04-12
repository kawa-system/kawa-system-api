package com.kawa.api.commons.errors.enums;

import com.kawa.api.commons.errors.constants.LevelConstants;

/**
 * This <code>enum</code> represents a requirement level as specified in the
 * Best Current Practice #14 published by the Internet Engineering Task Force
 * inside the  <a href="https://www.ietf.org/rfc/rfc2119.txt">RFC-2119</a>
 * "Key words for use in RFCs to Indicate Requirement Levels".
 * <hr>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public enum RequirementLevel {

    /** Requirement Level : MUST. */
    MUST(LevelConstants.MUST_NAME,
            LevelConstants.MUST_DESC,
            new String[] {LevelConstants.REQUIRED_NAME,
                    LevelConstants.SHALL_NAME}),

    /** Requirement Level : MUST_NOT. */
    MUST_NOT(LevelConstants.MUST_NOT_NAME,
            LevelConstants.MUST_NOT_DESC,
            new String[] {LevelConstants.SHALL_NOT_NAME}),

    /** Requirement Level : SHOULD. */
    SHOULD(LevelConstants.SHOULD_NAME,
            LevelConstants.SHOULD_DESC,
            new String[] {LevelConstants.RECOMMENDED_NAME}),

    /** Requirement Level : SHOULD NOT. */
    SHOULD_NOT(LevelConstants.SHOULD_NOT_NAME,
            LevelConstants.SHOULD_NOT_DESC,
            new String[] {LevelConstants.NOT_RECOMMENDED_NAME}),

    /** Requirement Level : MAY. */
    MAY(LevelConstants.MAY_NAME,
            LevelConstants.MAY_DESC,
            new String[] {LevelConstants.OPTIONAL_NAME}),

    /** Requirement Level : UNKNOWN. */
    UNKNOWN(LevelConstants.UNKNOWN_NAME,
            LevelConstants.UNKNOWN_DESC,
            new String[0]);

    /** The name of the Requirement Level. */
    private final String name;
    /** The description of the Requirement Level. */
    private final String description;
    /** The synonyms of the Requirement Level. */
    private final String[] synonyms;

    /**
     * Constructor.
     * @param sName Name.
     * @param sDescription Description.
     * @param oSynonyms Synonyms.
     * @since 0.1.0 hydrogen
     */
    RequirementLevel(
            final String sName,
            final String sDescription,
            final String[] oSynonyms) {
        this.name = sName;
        this.description = sDescription;
        this.synonyms = oSynonyms;
    }

    /**
     * @return the name.
     * @since 0.1.0 hydrogen
     */
    public final String getName() {
        return this.name;
    }

    /**
     * @return the description.
     * @since 0.1.0 hydrogen
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     * @return the synonyms.
     * @since 0.1.0 hydrogen
     */
    public final String[] getSynonyms() {
        /* Clone synonym array for security reason. */
        final String[] oClone = new String[this.synonyms.length];
        System.arraycopy(this.synonyms, 0,  oClone, 0, this.synonyms.length);
        return oClone;
    }

}
