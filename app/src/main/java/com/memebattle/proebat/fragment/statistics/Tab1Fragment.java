package com.memebattle.proebat.fragment.statistics;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.memebattle.proebat.R;
import com.memebattle.proebat.core.domain.RoomService;

import java.util.Date;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab1Fragment extends Fragment {

    private TextView amountOfMissTextView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        amountOfMissTextView = view.findViewById(R.id.amount_miss_classes_text_view);
        RoomService.getInstance().getSumOfMiss(new RoomService.GetDataCallback<Long>() {

            @Override
            public void onSuccess(Long result) {
                if (result != null && amountOfMissTextView != null) {
                    amountOfMissTextView.setText(result.toString());
                }

            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        }, new Date().getTime() - 604800000, new Date().getTime());

    }


}