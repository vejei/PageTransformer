package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class RotateOutTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setPivotX(0);
        page.setPivotY(0);
        page.setTranslationX(-position * page.getWidth());

        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1 - Math.abs(position));
            page.setRotation(90 * -position);
            page.setTranslationZ(0);
        } else if (position <= 1) {
            page.setAlpha(1);
            page.setRotation(0);
            page.setTranslationZ(-1);
        } else {
            page.setAlpha(0f);
        }
    }
}
