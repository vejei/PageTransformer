package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.IntDef;
import androidx.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SimplePageTransformer extends PageTransformer {
    @Retention(RetentionPolicy.SOURCE)
    @IntDef(value = {
            CUBE_INSIDE, CUBE_OUTSIDE, DEPTH, FADE_SLIDE, FADE, FAN, GATE, ROTATE_DOWN, ROTATE_UP,
            ROTATE_HORIZONTAL, ROTATE_VERTICAL, SCALE, SIDE_BY_SIDE, STACK_BOTTOM, STACK_TOP,
            ZOOM_IN, ZOOM_OUT
    })
    public @interface PageTransformerName {}

    public static final int CUBE_INSIDE = 0;
    public static final int CUBE_OUTSIDE = 1;
    public static final int DEPTH = 2;
    public static final int FADE_SLIDE = 3;
    public static final int FADE = 4;
    public static final int FAN = 5;
    public static final int GATE = 6;
    public static final int ROTATE_DOWN = 7;
    public static final int ROTATE_UP = 8;
    public static final int ROTATE_HORIZONTAL = 9;
    public static final int ROTATE_VERTICAL = 10;
    public static final int SCALE = 11;
    public static final int SIDE_BY_SIDE = 12;
    public static final int STACK_BOTTOM = 13;
    public static final int STACK_TOP = 14;
    public static final int ZOOM_IN = 15;
    public static final int ZOOM_OUT = 16;

    private final int transformerName;
    private PageTransformer pageTransformer;

    public SimplePageTransformer(@PageTransformerName int name) {
        transformerName = name;
        switch (name) {
            case CUBE_INSIDE:
                pageTransformer = new CubeInsideTransformer();
                break;
            case CUBE_OUTSIDE:
                pageTransformer = new CubeOutsideTransformer();
                break;
            case DEPTH:
                pageTransformer = new DepthTransformer();
                break;
            case FADE_SLIDE:
                pageTransformer = new FadeSlideTransformer();
                break;
            case FADE:
                pageTransformer = new FadeTransformer();
                break;
            case FAN:
                pageTransformer = new FanTransformer();
                break;
            case GATE:
                pageTransformer = new GateTransformer();
                break;
            case ROTATE_DOWN:
                pageTransformer = new RotateDownTransformer();
                break;
            case ROTATE_UP:
                pageTransformer = new RotateUpTransformer();
                break;
            case ROTATE_HORIZONTAL:
                pageTransformer = new RotateHorizontalTransformer();
                break;
            case ROTATE_VERTICAL:
                pageTransformer = new RotateVerticalTransformer();
                break;
            case SCALE:
                pageTransformer = new ScaleTransformer();
                break;
            case SIDE_BY_SIDE:
                pageTransformer = new SideBySideTransformer();
                break;
            case STACK_BOTTOM:
                pageTransformer = new StackBottomTransformer();
                break;
            case STACK_TOP:
                pageTransformer = new StackTopTransformer();
                break;
            case ZOOM_IN:
                pageTransformer = new ZoomInTransformer();
                break;
            case ZOOM_OUT:
                pageTransformer = new ZoomOutTransformer();
                break;
        }
    }

    @PageTransformerName
    public int getTransformerName() {
        return transformerName;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        pageTransformer.transformPage(page, position);
    }
}
