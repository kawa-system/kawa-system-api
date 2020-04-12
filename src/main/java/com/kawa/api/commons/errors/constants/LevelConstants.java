package com.kawa.api.commons.errors.constants;

/**
 * <b>Level</b> <code>class</code> of Constants.
 * <br>
 *
 * @author <a href="https://github.com/old-papa-bear">Nicolas "P.B." ROLLE</a>
 * @version 0.1.0 hydrogen
 */
public final class LevelConstants {

    /** Enumeration's Name : MUST. */
    public static final String MUST_NAME = "MUST"; //$NON-NLS-1$
    /** Enumeration's Name : REQUIRED. */
    public static final String REQUIRED_NAME = "REQUIRED"; //$NON-NLS-1$
    /** Enumeration's Name : SHALL. */
    public static final String SHALL_NAME = "SHALL"; //$NON-NLS-1$
    /** Enumeration's Name : MUST NOT. */
    public static final String MUST_NOT_NAME = "MUST NOT"; //$NON-NLS-1$
    /** Enumeration's Name : SHALL NOT. */
    public static final String SHALL_NOT_NAME = "SHALL NOT"; //$NON-NLS-1$
    /** Enumeration's Name : SHOULD. */
    public static final String SHOULD_NAME = "SHOULD"; //$NON-NLS-1$
    /** Enumeration's Name : RECOMMANDED. */
    public static final String RECOMMENDED_NAME = "RECOMMENDED"; //$NON-NLS-1$
    /** Enumeration's Name : SHOULD NOT. */
    public static final String SHOULD_NOT_NAME = "SHOULD NOT"; //$NON-NLS-1$
    /** Enumeration's Name : NOT RECOMMENDED. */
    public static final String NOT_RECOMMENDED_NAME
        = "NOT RECOMMENDED"; //$NON-NLS-1$
    /** Enumeration's Name : MAY. */
    public static final String MAY_NAME = "MAY"; //$NON-NLS-1$
    /** Enumeration's Name : OPTIONAL. */
    public static final String OPTIONAL_NAME = "OPTIONAL"; //$NON-NLS-1$
    /** Enumeration's Name : UNKNOWN. */
    public static final String UNKNOWN_NAME = "UNKNOWN"; //$NON-NLS-1$

    /** Enumeration's Description : MUST. */
    public static final String MUST_DESC
        = "This word, or the terms \"REQUIRED\" or \"SHALL\", " //$NON-NLS-1$
                + "mean that the definition is an absolute " //$NON-NLS-1$
                + "requirement of the specification."; //$NON-NLS-1$

    /** Enumeration's Description : MUST NOT. */
    public static final String MUST_NOT_DESC
        = "This phrase, or the phrase \"SHALL NOT\", mean that " //$NON-NLS-1$
                + "the definition is an absolute prohibition of " //$NON-NLS-1$
                + "the specification."; //$NON-NLS-1$

    /** Enumeration's Description : SHOULD. */
    public static final String SHOULD_DESC
        = "This word, or the adjective \"RECOMMENDED\", mean " //$NON-NLS-1$
                + "that there may exist valid reasons in " //$NON-NLS-1$
                + "particular circumstances to ignore a " //$NON-NLS-1$
                + "particular item, but the full implications " //$NON-NLS-1$
                + "must be understood and carefully weighed " //$NON-NLS-1$
                + "before choosing a different course."; //$NON-NLS-1$

    /** Enumeration's Description : SHOULD NOT. */
    public static final String SHOULD_NOT_DESC
        = "This phrase, or the phrase \"NOT RECOMMENDED\" mean " //$NON-NLS-1$
                + "that there may exist valid reasons in " //$NON-NLS-1$
                + "particular circumstances when the particular " //$NON-NLS-1$
                + "behavior is acceptable or even useful, but the" //$NON-NLS-1$
                + " full implications should be understood and " //$NON-NLS-1$
                + "the case carefully weighed before implementing" //$NON-NLS-1$
                + " any behavior described with this label."; //$NON-NLS-1$

    /** Enumeration's Description : MAY. */
    public static final String MAY_DESC
        = "This word, or the adjective \"OPTIONAL\", mean that " //$NON-NLS-1$
                + "an item is truly optional. One vendor may " //$NON-NLS-1$
                + "choose to include the item because a " //$NON-NLS-1$
                + "particular marketplace requires it or because " //$NON-NLS-1$
                + "the vendor feels that it enhances the product " //$NON-NLS-1$
                + "while another vendor may omit the same item. " //$NON-NLS-1$
                + "An implementation which does not include a " //$NON-NLS-1$
                + "particular option MUST be prepared to " //$NON-NLS-1$
                + "interoperate with another implementation which" //$NON-NLS-1$
                + " does include the option, though perhaps with " //$NON-NLS-1$
                + "reduced functionality. In the same vein an " //$NON-NLS-1$
                + "implementation which does include a particular" //$NON-NLS-1$
                + " option MUST be prepared to interoperate with " //$NON-NLS-1$
                + "another implementation which does not include " //$NON-NLS-1$
                + "the option (except, of course, for the feature" //$NON-NLS-1$
                + " the option provides.)"; //$NON-NLS-1$

    /** Enumeration's Description : UNKNOWN. */
    public static final String UNKNOWN_DESC
        = "This word represents an UNKNOWN requirement level. " //$NON-NLS-1$
                + "This one MUST be used only for technical " //$NON-NLS-1$
                + "reasons."; //$NON-NLS-1$

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private LevelConstants() {
        super();
    }

}
