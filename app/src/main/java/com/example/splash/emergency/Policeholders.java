package com.example.splash.emergency;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.R;

public class Policeholders extends RecyclerView.ViewHolder {

    ImageView imageViewp;
    TextView textViewp1,textViewp2,textViewp3,textViewp4,textViewp5,textViewp6;
    View v;


    public Policeholders(@NonNull View itemView) {
        super(itemView);

        imageViewp = itemView.findViewById(R.id.policephoto);
        textViewp1 = itemView.findViewById(R.id.locationp);
        textViewp2 = itemView.findViewById(R.id.namep);
        textViewp3 = itemView.findViewById(R.id.phonep);
        textViewp4 = itemView.findViewById(R.id.landlinep);
        textViewp5 = itemView.findViewById(R.id.sendsmsp);
        textViewp6 = itemView.findViewById(R.id.sendwhatsappp);
        v = itemView;

    }
}
