package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class FadeTransformer extends PageTransformer {
    private float minAlpha;

    public FadeTransformer() {
        this(0f);
    }

    public FadeTransformer(float minAlpha) {
        this.minAlpha = minAlpha;
    }

    public float getMinAlpha() {
        return minAlpha;
    }

    public void setMinAlpha(float minAlpha) {
        this.minAlpha = minAlpha;
    }

    @Override
    public void transformPage(@NonNull View page, float position) {
        float alpha = Math.max(minAlpha, 1 - Math.abs(position));
        page.setAlpha(alpha);
        page.setTranslationX(page.getWidth() * -position);
    }
}
