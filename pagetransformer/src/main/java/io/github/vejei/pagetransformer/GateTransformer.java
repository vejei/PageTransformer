package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class GateTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setTranslationX(-position * page.getWidth());

        if (position < 0) {
            page.setPivotX(0);
        } else {
            page.setPivotX(page.getWidth());
        }
        page.setPivotY(page.getHeight() / 2f);

        if (position < -1) {
            page.setAlpha(0);
        } else if (position <= 1) {
            page.setAlpha(1f);
            page.setRotationY(-90 * position);
        } else {
            page.setAlpha(0);
        }
    }
}
