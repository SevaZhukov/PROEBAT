package com.memebattle.proebat.features.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.memebattle.proebat.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SettingsFragment extends Fragment {

    TextView share;
    TextView humoreski;
    TextView aneks;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        share = view.findViewById(R.id.share);
        humoreski = view.findViewById(R.id.humoreski);
        aneks = view.findViewById(R.id.aneks);

        share.setOnClickListener(v -> {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Я проебываю пары!");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });
        humoreski.setOnClickListener(v -> {
            Uri address = Uri.parse("https://vk.com/jumoreski");
            Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openlinkIntent);
        });
        aneks.setOnClickListener(v -> {
            Uri address = Uri.parse("https://vk.com/baneks");
            Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
            startActivity(openlinkIntent);
        });
        return view;
    }
}
