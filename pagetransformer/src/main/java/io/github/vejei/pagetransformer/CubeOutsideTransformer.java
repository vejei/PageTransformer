package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class CubeOutsideTransformer extends PageTransformer {
    private float cameraDistanceFactor;

    public CubeOutsideTransformer() {
        this(4.5f);
    }

    public CubeOutsideTransformer(float cameraDistanceFactor) {
        this.cameraDistanceFactor = cameraDistanceFactor;
    }

    public float getCameraDistanceFactor() {
        return cameraDistanceFactor;
    }

    public void setCameraDistanceFactor(float cameraDistanceFactor) {
        this.cameraDistanceFactor = cameraDistanceFactor;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setCameraDistance(page.getHeight() * cameraDistanceFactor);

        if (position < 0) {
            page.setPivotX(page.getWidth());
        } else {
            page.setPivotX(0);
        }
        page.setPivotY(page.getHeight() / 2f);

        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 1) {
            page.setAlpha(1f);
            page.setRotationY(90 * position);
        } else {
            page.setAlpha(0f);
        }
    }
}
