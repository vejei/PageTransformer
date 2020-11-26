package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class RotationVerticalTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        page.setCameraDistance(15000);
        page.setTranslationX(-position * page.getWidth());

        if (position < 0.5 && position > -0.5) {
            page.setVisibility(View.VISIBLE);
        } else {
            page.setVisibility(View.INVISIBLE);
        }

        if (position < -1) {
            page.setAlpha(0f);
        } else if (position <= 0) {
            page.setAlpha(1f);
            page.setRotationY(180 * (1 - Math.abs(position)));
        } else if (position <= 1) {
            page.setAlpha(1f);
            page.setRotationY(-180 * (1 - Math.abs(position)));
        } else {
            page.setAlpha(0f);
        }
    }
}
