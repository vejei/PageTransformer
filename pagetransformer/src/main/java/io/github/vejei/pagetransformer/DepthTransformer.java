package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class DepthTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1f);
            page.setScaleX(1f);
            page.setScaleY(1f);

            page.setTranslationX(0f);
            page.setTranslationZ(0f);
        } else if (position <= 1) {
            page.setAlpha(1 - position);
            page.setScaleX(1 - position);
            page.setScaleY(1 - position);

            page.setTranslationX(page.getWidth() * -position);
            page.setTranslationZ(-1f);
        } else {
            page.setAlpha(0f);
        }
    }
}
