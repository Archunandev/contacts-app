package com.example.splash;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Electriholder extends RecyclerView.ViewHolder {

    ImageView imageViewe;
    TextView textViewe1,textViewe2,textViewe3,textViewe4,textViewe5;
    View v;

    public Electriholder(@NonNull View itemView) {
        super(itemView);
        imageViewe = itemView.findViewById(R.id.electriphoto);
        textViewe1 = itemView.findViewById(R.id.locatione);
        textViewe2 = itemView.findViewById(R.id.namee);
        textViewe3 = itemView.findViewById(R.id.phonee);
        textViewe4 = itemView.findViewById(R.id.smse);
        textViewe5 = itemView.findViewById(R.id.whatsappe);

        v = itemView;
    }
}