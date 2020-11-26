package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class ZoomInTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(-position * page.getWidth());

        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1);
            page.setScaleX(1 - Math.abs(position));
            page.setScaleY(1 - Math.abs(position));
            page.setPivotX(page.getWidth() / 2f);
            page.setPivotY(page.getHeight() / 2f);
            page.setTranslationZ(position < 0 ? 0 : -1);
        } else {
            page.setAlpha(0);
        }
    }
}
