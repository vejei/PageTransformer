package io.github.vejei.pagetransformer;

import android.view.View;

import androidx.annotation.NonNull;

public class StackTopTransformer extends PageTransformer {
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) {
            page.setTranslationX(0f);
        } else if (position <= 0) {
            page.setTranslationX(0f);
            page.setTranslationZ(0);
        } else if (position <= 1) {
            page.setTranslationX(-position * page.getWidth());
            page.setTranslationZ(-1);
        } else {
            page.setTranslationX(0f);
        }
    }
}
