package com.hassanabid.gdgfestgles3;

import android.content.Context;
import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by hassanabid on 11/3/16.
 */

public class GLESJNIView extends GLSurfaceView {


    public  GLESJNIView(Context context) {

        super(context);

        // Pick an EGLConfig with RGB8 color, 16-bit depth, no stencil,
        // supporting OpenGL ES 2.0 or later backwards-compatible versions.
        setEGLConfigChooser(8, 8, 8, 0, 16, 0);
        setEGLContextClientVersion(2);
        setRenderer(new Renderer());
    }

    public static class Renderer implements GLSurfaceView.Renderer {

        @Override
        public void onSurfaceCreated(GL10 gl10, EGLConfig eglConfig) {
                GLESJNILib.init();
        }

        @Override
        public void onSurfaceChanged(GL10 gl10, int i, int i1) {

            GLESJNILib.resize(i,i1);
        }

        @Override
        public void onDrawFrame(GL10 gl10) {

            GLESJNILib.step();
        }
    }

}
