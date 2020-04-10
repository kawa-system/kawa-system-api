package com.kawa.api.constants;

/**
 * <b>Project</b> Constants <code>class</code>.
 * <br>
 *
 * The purpose of this <code>class</code> is to provide constant(s) dedicated to
 * {@link com.kawa.api.models.Project}.
 * <hr>
 *
 * @version 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public final class ProjectConstants {

    /** Name : Minimum Size. */
    public static final int NAME_MINIMUM_SIZE = 3;
    /** Name : Maximum Size. */
    public static final int NAME_MAXIMUM_SIZE = 40;

    /** Hash Code Multiplier Value. */
    public static final int HC = 10007;

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private ProjectConstants() {
        super();
    }

}
