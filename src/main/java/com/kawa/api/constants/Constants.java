package com.kawa.api.constants;

/**
 * <b>Contants</b> <code>class</code>.
 * <br>
 *
 * The purpose of this <code>class</code> is to provide global constant
 * to the project.
 * <hr>
 *
 * @version 0.1.0 hydrogen
 * @author Nicolas "Papa Bear" ROLLE
 */
public final class Constants {

    /** Global Serial Unique Version ID. */
    public static final long SUID = 0x01_00_0001_00000000L;

    /** Hash Code Initial Value. */
    public static final int HC = 5;

    /** Default Maximum length. */
    public static final int DEFAULT_MAXIMUM_LENGTH = 4096;

    /**
     * Constructor.
     * <i>As the purpose of this <code>class</code> is to provide static fields
     * only, there's no reason to create new instance of this one. So, the
     * constructor access will be restrict to <code>private</code>.</i>
     * <hr>
     * @since 0.1.0 hydrogen
     */
    private Constants() {
        super();
    }

}
