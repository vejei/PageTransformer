package io.github.vejei.pagetransformer.samples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PageFragment extends Fragment {
    private static final String ARG_COLOR = "color";

    private int viewColor;

    public PageFragment() {
        // Required empty public constructor
    }

    public static PageFragment newInstance(@ColorInt int color) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLOR, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            viewColor = getArguments().getInt(ARG_COLOR);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        View colorfulView = view.findViewById(R.id.view_colorful);
        colorfulView.setBackgroundColor(viewColor);
    }
}
