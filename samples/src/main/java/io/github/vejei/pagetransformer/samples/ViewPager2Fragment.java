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
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.List;
import java.util.Objects;

import io.github.vejei.pagetransformer.PageTransformer;

public class ViewPager2Fragment extends Fragment {

    private final int[] colors = {
            Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.CYAN, Color.GRAY, Color.BLACK
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view_pager2_samples, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SamplesActivity activity = ((SamplesActivity) Objects.requireNonNull(getActivity()));
        PageTransformer[] transformers = activity.transformers;
        List<String> transformerNames = activity.transformerNames;

        AppCompatSpinner spinner = view.findViewById(R.id.spinner);

        PageAdapter adapter = new PageAdapter();
        ViewPager2 viewPager = view.findViewById(R.id.view_pager2);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(2);

        spinner.setAdapter(new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,
                android.R.id.text1, transformerNames));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                viewPager.setAdapter(adapter);
                viewPager.setPageTransformer(transformers[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                viewPager.setPageTransformer(null);
            }
        });
    }

    class PageAdapter extends RecyclerView.Adapter<PageViewHolder> {
        @NonNull
        @Override
        public PageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PageViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_page, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull PageViewHolder holder, int position) {
            holder.bind(colors[position]);
        }

        @Override
        public int getItemCount() {
            return colors.length;
        }
    }

    static class PageViewHolder extends RecyclerView.ViewHolder {
        private final View colorfulView;

        public PageViewHolder(@NonNull View itemView) {
            super(itemView);
            colorfulView = itemView.findViewById(R.id.view_colorful);
        }

        void bind(int color) {
            colorfulView.setBackgroundColor(color);

        }
    }
}
