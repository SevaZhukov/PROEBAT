package com.memebattle.proebat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.memebattle.proebat.App;
import com.memebattle.proebat.R;
import com.memebattle.proebat.core.data.Miss;
import com.memebattle.proebat.core.domain.RoomService;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MissFragment extends Fragment {

    RoomService roomService = RoomService.getInstance();

    private TextView allText;
    private TextView wantText;

    private ImageView allPlus;
    private ImageView allMinus;
    private ImageView wantPlus;
    private ImageView wantMinus;

    private Button missLeft;
    private Button missRight;

    private int countAll = 1;
    private int countWant = 1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_miss, container, false);

        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host);

        roomService.getMiss(new RoomService.GetDataCallback<Miss>() {
            @Override
            public void onSuccess(Miss result) {
                Date date = new Date(result.getDate());
                if(date.getDay() == new Date().getDay()) {
                    //navController.navigate();
                }
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });

        allText = v.findViewById(R.id.all_count);
        wantText = v.findViewById(R.id.want_count);
        allPlus = v.findViewById(R.id.all_plus);
        allMinus = v.findViewById(R.id.all_minus);
        wantPlus = v.findViewById(R.id.want_plus);
        wantMinus = v.findViewById(R.id.want_minus);
        missLeft = v.findViewById(R.id.miss_left);
        missRight = v.findViewById(R.id.miss_right);

        allPlus.setOnClickListener(v1 -> {
            countAll++;
            allText.setText(countAll + "");
        });
        allMinus.setOnClickListener(v1 -> {
            if (countAll > 1) {
                countAll--;
                allText.setText(countAll + "");
            }
            if(countAll < countWant) {
                countWant = countAll;
                wantText.setText(countWant);
            }
        });
        wantPlus.setOnClickListener(v1 -> {
            if (countWant < countAll) {
                countWant++;
                wantText.setText(countWant + "");
            }
        });
        wantMinus.setOnClickListener(v1 -> {
            if (countWant > 1) {
                countWant--;
                wantText.setText(countWant + "");
            }
        });
        missLeft.setOnClickListener(v12 -> {
            roomService.createMiss(new Miss(new Date().getTime(), countAll, countWant));
        });
        missRight.setOnClickListener(v12 -> {
            roomService.createMiss(new Miss(new Date().getTime(), countAll, countWant));
        });
        return v;
    }
}
