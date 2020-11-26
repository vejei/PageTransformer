package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class ScaleTransformer extends PageTransformer {
    private float minScale;

    public ScaleTransformer() {
        this(0.85f);
    }

    public ScaleTransformer(float minScale) {
        this.minScale = minScale;
    }

    public float getMinScale() {
        return minScale;
    }

    public void setMinScale(float minScale) {
        this.minScale = minScale;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setPivotX(page.getWidth() / 2f);
        page.setPivotY(page.getHeight() / 2f);

        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 1) {
            float scaleFactor = Math.max(1 - Math.abs(position), minScale);
            page.setAlpha(1f);
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
        } else {
            page.setAlpha(0f);
        }
    }
}
