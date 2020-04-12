package com.kawa.api.commons.errors.utils;

import java.util.HashMap;
import java.util.Map;

import com.kawa.api.commons.errors.enums.RequirementLevel;

/**
 * Requirement <b>Level</b> Utilities.
 * <br>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class RequirementLevelUtils {

    /** Map of requirement levels. */
    private static final Map<String, RequirementLevel> VALUES = buildMap();

    /**
     * Constructor.
     * @since 0.1.0 hydrogen
     */
    private RequirementLevelUtils() {
        super();
    }

    /**
     * @return the map of requirements level.
     * @since 0.1.0 hydrogen
     */
    private static Map<String, RequirementLevel> buildMap() {
        final Map<String, RequirementLevel> map = new HashMap<>();

        for (RequirementLevel oLevel : RequirementLevel.values()) {
            map.put(oLevel.getName().trim().toUpperCase(), oLevel);
            for (String sSynonym : oLevel.getSynonyms()) {
                map.put(sSynonym.trim().toUpperCase(), oLevel);
            }
        }

        return map;
    }

    /**
     * Used to find a level for a given String.
     * @param sLevel The level as a String.
     * @return A level.
     * @since 0.1.0 hydrogen
     */
    public static RequirementLevel findLevel(final String sLevel) {
        /* Null Case. */
        if (sLevel == null) {
            return RequirementLevel.UNKNOWN;
        }
        final RequirementLevel oLevel = VALUES.get(sLevel.trim().toUpperCase());
        if (oLevel == null) {
            return RequirementLevel.UNKNOWN;
        }
        return oLevel;
    }

}
