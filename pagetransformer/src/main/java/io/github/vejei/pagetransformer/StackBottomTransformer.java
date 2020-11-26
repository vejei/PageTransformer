package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class StackBottomTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            page.setTranslationX(0f);
        } else if (position <= 0) {
            page.setTranslationX(-position * page.getWidth());
        } else if (position <= 1) {
            page.setTranslationX(0f);
        } else {
            page.setTranslationX(0f);
        }
    }
}
