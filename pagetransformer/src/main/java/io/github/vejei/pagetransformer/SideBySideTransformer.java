package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class SideBySideTransformer extends PageTransformer {
    private float minScale;

    public SideBySideTransformer() {
        this(0.85f);
    }

    public SideBySideTransformer(float minScale) {
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
        float pageWidth = page.getWidth();
        float pageHeight = page.getHeight();

        page.setPivotX(pageWidth / 2f);
        page.setPivotY(pageHeight / 2f);

        if (position < -1) {
            page.setPivotX(pageWidth);
            page.setScaleX(minScale);
            page.setScaleY(minScale);
        } else if (position <= 1) {
            float scaleFactor = Math.max(minScale, (1 - Math.abs(position)));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);
            page.setPivotX(pageWidth / 2f * (1 - position));
        } else {
            page.setPivotX(0);
            page.setScaleX(minScale);
            page.setScaleY(minScale);
        }
    }
}
