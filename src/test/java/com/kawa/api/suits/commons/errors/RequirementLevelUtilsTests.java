package com.kawa.api.suits.commons.errors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.kawa.api.commons.errors.enums.RequirementLevel;
import com.kawa.api.commons.errors.utils.RequirementLevelUtils;

/**
 * <b>Requirement Level Utilities</b> Unit Tests.
 * <br>
 *
 * This <code>class</code> is used to check the {@link RequirementLevelUtils}
 * <code>enum</code>.
 * @author <a href="https://github.com/old-papa-bear">Nicolas P.B. ROLLE</a>
 * @version 0.1.0 hydrogen
 */
@DisplayName("Commons >> Errors >> Level Requirements >> Utils")
public final class RequirementLevelUtilsTests {

    /**
     * Test {@link RequirementLevelUtils#findLevel(String)}.
     * @param sToSearch The value to search.
     * @param sExpectedName The expected name.
     * @param sExpectedDescription The expected description.
     */
    @DisplayName("find level")
    @SuppressWarnings("static-method")
    @ParameterizedTest
    @CsvFileSource(resources
            = "/test-set/errors/"
            + "requirement-level-utils-find.csv",
            delimiter = ';',
            numLinesToSkip = 1)
    public void checkFind(
            final String sToSearch,
            final String sExpectedName,
            final String sExpectedDescription) {
        final RequirementLevel oLevel;

        Assertions.assertEquals(
                RequirementLevel.UNKNOWN,
                RequirementLevelUtils.findLevel(null));

        oLevel =  RequirementLevelUtils.findLevel(sToSearch);

        Assertions.assertNotNull(oLevel);
        Assertions.assertEquals(sExpectedName, oLevel.getName());
        Assertions.assertEquals(sExpectedDescription, oLevel.getDescription());
    }

}
