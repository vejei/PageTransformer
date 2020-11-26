package io.github.vejei.pagetransformer.samples;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.List;
import java.util.Objects;

import io.github.vejei.pagetransformer.PageTransformer;

public class ViewPagerFragment extends Fragment {

    private final int[] colors = {
            Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN, Color.GRAY, Color.BLACK
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager_samples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SamplesActivity activity = ((SamplesActivity) Objects.requireNonNull(getActivity()));
        PageTransformer[] transformers = activity.transformers;
        List<String> transformerNames = activity.transformerNames;

        PagerAdapter pagerAdapter = new FragmentStatePagerAdapter(getChildFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return PageFragment.newInstance(colors[position]);
            }

            @Override
            public int getCount() {
                return colors.length;
            }
        };

        AppCompatSpinner spinner = view.findViewById(R.id.spinner);
        ViewPager viewPager = view.findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);

        spinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, transformerNames));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setAdapter(pagerAdapter);
                viewPager.setPageTransformer(false, transformers[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                viewPager.setPageTransformer(false, null);
            }
        });
    }
}
