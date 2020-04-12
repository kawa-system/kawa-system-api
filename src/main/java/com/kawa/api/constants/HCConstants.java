package com.kawa.api.constants;

/**
 * <b>Hash Code</b> Constants <code>class</code>.
 * <br>
 *
 * The purpose of this <code>class</code> is to provide the hash code of this
 * project.
 * <hr>
 *
 * @version 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public final class HCConstants {

    /** Hash Code Initial Value. */
    public static final int HC_INIT = 5;

    /** Hash Code Multiplier Value - Bean : Project. */
    public static final int HC_MLT_BEAN_PROJECT = 10007;

    /** Hash Code Multiplier Value - Interface : Rule. */
    public static final int HC_MLT_FAC_RULE = 20011;

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private HCConstants() {
        super();
    }

}
