package com.hassanabid.gdgfestgles3;

/**
 * Created by hassanabid on 11/3/16.
 */

public class GLESJNILib {

    static  {

        System.loadLibrary("native-lib");
    }

    public static native void init();
    public static native void resize(int width, int height);
    public static native void step();
}
