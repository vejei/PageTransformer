package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class FanTransformer extends PageTransformer {
    private float cameraDistanceFactor;
    private float angle;

    public FanTransformer() {
        this(15, 90);
    }

    public FanTransformer(float cameraDistanceFactor, float angle) {
        this.cameraDistanceFactor = cameraDistanceFactor;
        this.angle = Math.max(60, Math.min(120, angle));
    }

    public float getCameraDistanceFactor() {
        return cameraDistanceFactor;
    }

    public void setCameraDistanceFactor(float cameraDistanceFactor) {
        this.cameraDistanceFactor = cameraDistanceFactor;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = Math.max(60, Math.min(120, angle));
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setCameraDistance(page.getHeight() * cameraDistanceFactor);
        page.setPivotX(0);
        page.setPivotY(page.getHeight() / 2f);
        page.setTranslationX(page.getWidth() * -position);

        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1f);
            page.setRotationY(angle * position);
            page.setTranslationZ(position <= 0 ? 0 : -1);
        } else {
            page.setAlpha(0);
        }
    }
}
