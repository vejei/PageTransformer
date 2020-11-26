package io.github.vejei.pagetransformer.samples;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.github.vejei.pagetransformer.CubeInsideTransformer;
import io.github.vejei.pagetransformer.CubeOutsideTransformer;
import io.github.vejei.pagetransformer.DepthTransformer;
import io.github.vejei.pagetransformer.FadeSlideTransformer;
import io.github.vejei.pagetransformer.FadeTransformer;
import io.github.vejei.pagetransformer.FanTransformer;
import io.github.vejei.pagetransformer.GateTransformer;
import io.github.vejei.pagetransformer.PageTransformer;
import io.github.vejei.pagetransformer.RotateDownTransformer;
import io.github.vejei.pagetransformer.RotateUpTransformer;
import io.github.vejei.pagetransformer.RotationHorizontalTransformer;
import io.github.vejei.pagetransformer.RotationVerticalTransformer;
import io.github.vejei.pagetransformer.ScaleTransformer;
import io.github.vejei.pagetransformer.SideBySideTransformer;
import io.github.vejei.pagetransformer.SimplePageTransformer;
import io.github.vejei.pagetransformer.StackBottomTransformer;
import io.github.vejei.pagetransformer.StackTopTransformer;
import io.github.vejei.pagetransformer.ZoomInTransformer;
import io.github.vejei.pagetransformer.ZoomOutTransformer;

public class SamplesActivity extends AppCompatActivity {
    final PageTransformer[] transformers = {
            new SimplePageTransformer(SimplePageTransformer.CUBE_INSIDE),
            new SimplePageTransformer(SimplePageTransformer.CUBE_OUTSIDE),
            new SimplePageTransformer(SimplePageTransformer.DEPTH),
            new SimplePageTransformer(SimplePageTransformer.FADE_SLIDE),
            new SimplePageTransformer(SimplePageTransformer.FADE),
            new SimplePageTransformer(SimplePageTransformer.FAN),
            new SimplePageTransformer(SimplePageTransformer.GATE),
            new SimplePageTransformer(SimplePageTransformer.ROTATE_DOWN),
            new SimplePageTransformer(SimplePageTransformer.ROTATE_UP),
            new SimplePageTransformer(SimplePageTransformer.ROTATION_HORIZONTAL),
            new SimplePageTransformer(SimplePageTransformer.ROTATION_VERTICAL),
            new SimplePageTransformer(SimplePageTransformer.SCALE),
            new SimplePageTransformer(SimplePageTransformer.SIDE_BY_SIDE),
            new SimplePageTransformer(SimplePageTransformer.STACK_BOTTOM),
            new SimplePageTransformer(SimplePageTransformer.STACK_TOP),
            new SimplePageTransformer(SimplePageTransformer.ZOOM_IN),
            new SimplePageTransformer(SimplePageTransformer.ZOOM_OUT)
    };
    final List<String> transformerNames = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samples);

        int sampleType = getIntent().getIntExtra("sample_type", 0);

        Fragment fragment = null;
        switch (sampleType) {
            case 0:
                fragment = new ViewPagerFragment();
                break;
            case 1:
                fragment = new ViewPager2Fragment();
                break;
        }

        transformerNames.clear();
        for (PageTransformer transformer : transformers) {
            int name = ((SimplePageTransformer) transformer).getTransformerName();
            switch (name) {
                case SimplePageTransformer.CUBE_INSIDE:
                    transformerNames.add(CubeInsideTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.CUBE_OUTSIDE:
                    transformerNames.add(CubeOutsideTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.DEPTH:
                    transformerNames.add(DepthTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.FADE:
                    transformerNames.add(FadeTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.FADE_SLIDE:
                    transformerNames.add(FadeSlideTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.FAN:
                    transformerNames.add(FanTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.GATE:
                    transformerNames.add(GateTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ROTATE_DOWN:
                    transformerNames.add(RotateDownTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ROTATE_UP:
                    transformerNames.add(RotateUpTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ROTATION_HORIZONTAL:
                    transformerNames.add(RotationHorizontalTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ROTATION_VERTICAL:
                    transformerNames.add(RotationVerticalTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.SCALE:
                    transformerNames.add(ScaleTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.SIDE_BY_SIDE:
                    transformerNames.add(SideBySideTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.STACK_BOTTOM:
                    transformerNames.add(StackBottomTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.STACK_TOP:
                    transformerNames.add(StackTopTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ZOOM_IN:
                    transformerNames.add(ZoomInTransformer.class.getSimpleName());
                    break;
                case SimplePageTransformer.ZOOM_OUT:
                    transformerNames.add(ZoomOutTransformer.class.getSimpleName());
                    break;
            }
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, Objects.requireNonNull(fragment))
                    .commit();
        }
    }
}
