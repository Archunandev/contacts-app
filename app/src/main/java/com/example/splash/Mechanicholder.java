package com.example.splash;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class Mechanicholder extends RecyclerView.ViewHolder {

    ImageView imageViewm;
    TextView textViewm1,textViewm2,textViewm3,textViewm4,textViewm5;
    View v;


    public Mechanicholder(@NonNull View itemView) {
        super(itemView);

        imageViewm = itemView.findViewById(R.id.mechanicphoto);
        textViewm1 = itemView.findViewById(R.id.locationm);
        textViewm2 = itemView.findViewById(R.id.namem);
        textViewm3 = itemView.findViewById(R.id.phonem);
        textViewm4 = itemView.findViewById(R.id.smsm);
        textViewm5 = itemView.findViewById(R.id.whatsappm);
        v = itemView;

    }
}
