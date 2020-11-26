package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class ZoomOutTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(-position * page.getWidth());

        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            float scale = 1 + Math.abs(position);

            page.setAlpha(1 - Math.abs(position));
            page.setScaleX(scale);
            page.setScaleY(scale);
        } else {
            page.setAlpha(0);
        }
    }
}
