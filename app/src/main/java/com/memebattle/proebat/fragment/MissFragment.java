package com.memebattle.proebat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.memebattle.proebat.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MissFragment extends Fragment {

    TextView allText;
    TextView wantText;

    ImageView allPlus;
    ImageView allMinus;
    ImageView wantPlus;
    ImageView wantMinus;

    Button missLeft;
    Button missRight;

    int countAll = 1;
    int countWant = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_miss, container, false);

        allText = v.findViewById(R.id.all_count);
        wantText = v.findViewById(R.id.want_count);
        allPlus = v.findViewById(R.id.all_plus);
        allMinus = v.findViewById(R.id.all_plus);
        wantPlus = v.findViewById(R.id.want_plus);
        wantMinus = v.findViewById(R.id.want_minus);

        allPlus.setOnClickListener(v1 -> {
            countAll++;
            allText.setText(countAll+"");
        });
        allMinus.setOnClickListener(v1 -> {
            countAll--;
            allText.setText(countAll+"");
        });
        wantPlus.setOnClickListener(v1 -> {
            countWant++;
            wantText.setText(countWant+"");
        });
        wantMinus.setOnClickListener(v1 -> {
            countWant--;
            wantText.setText(countAll+"");
        });
        missLeft.setOnClickListener(v12 -> {

        });
        missRight.setOnClickListener(v12 -> {

        });
        return v;
    }
}
