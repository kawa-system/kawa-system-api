package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kawa.api.commons.errors.constants.LevelConstants;
import com.kawa.api.commons.errors.enums.RequirementLevel;

/**
 * <b>Requirement Level Enumeration</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the {@link RequirementLevel} <code>
 * enum</code>.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Level Requirements >> Enum")
public final class RequirementLevelTests {

    /**
     * Test {@link RequirementLevel#MUST}.
     */
    @Test
    @DisplayName("value : MUST")
    @SuppressWarnings("static-method")
    public void checkMust() {
        final RequirementLevel oLevel = RequirementLevel.MUST;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.MUST_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.MUST_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[] {
                LevelConstants.REQUIRED_NAME,
                LevelConstants.SHALL_NAME},
                oLevel.getSynonyms());

    }

    /**
     * Test {@link RequirementLevel#MUST_NOT}.
     */
    @Test
    @DisplayName("value : MUST NOT")
    @SuppressWarnings("static-method")
    public void checkMustNot() {
        final RequirementLevel oLevel = RequirementLevel.MUST_NOT;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.MUST_NOT_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.MUST_NOT_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[] {
                LevelConstants.SHALL_NOT_NAME},
                oLevel.getSynonyms());

    }

    /**
     * Test {@link RequirementLevel#SHOULD}.
     */
    @Test
    @DisplayName("value : SHOULD")
    @SuppressWarnings("static-method")
    public void checkShould() {
        final RequirementLevel oLevel = RequirementLevel.SHOULD;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.SHOULD_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.SHOULD_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[] {
                LevelConstants.RECOMMENDED_NAME},
                oLevel.getSynonyms());

    }

    /**
     * Test {@link RequirementLevel#SHOULD_NOT}.
     */
    @Test
    @DisplayName("value : SHOULD NOT")
    @SuppressWarnings("static-method")
    public void checkShouldNot() {
        final RequirementLevel oLevel = RequirementLevel.SHOULD_NOT;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.SHOULD_NOT_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.SHOULD_NOT_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[] {
                LevelConstants.NOT_RECOMMENDED_NAME},
                oLevel.getSynonyms());

    }

    /**
     * Test {@link RequirementLevel#MAY}.
     */
    @Test
    @DisplayName("value : MAY")
    @SuppressWarnings("static-method")
    public void checkMay() {
        final RequirementLevel oLevel = RequirementLevel.MAY;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.MAY_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.MAY_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[] {
                LevelConstants.OPTIONAL_NAME},
                oLevel.getSynonyms());

    }

    /**
     * Test {@link RequirementLevel#UNKNOWN}.
     */
    @Test
    @DisplayName("value : UNKNOWN")
    @SuppressWarnings("static-method")
    public void checkUnknwon() {
        final RequirementLevel oLevel = RequirementLevel.UNKNOWN;

        /* Check Level. */
        Assertions.assertNotNull(oLevel);

        /* Check Name. */
        Assertions.assertEquals(
                LevelConstants.UNKNOWN_NAME,
                oLevel.getName());

        /* Check Description. */
        Assertions.assertEquals(
                LevelConstants.UNKNOWN_DESC,
                oLevel.getDescription());

        /* Check Synonyms. */
        Assertions.assertArrayEquals(new String[0],
                oLevel.getSynonyms());

    }

}
