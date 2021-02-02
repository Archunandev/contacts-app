package com.example.splash.shops;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.R;

public class Foodholders extends RecyclerView.ViewHolder {

    ImageView imageViewf;
    TextView textViewf1,textViewf2,textViewf3,textViewf4,textViewf5,textViewf6,textViewf7;
    View v;




    public Foodholders(@NonNull View itemView) {
        super(itemView);

        imageViewf = itemView.findViewById(R.id.foodphoto);
        textViewf1 = itemView.findViewById(R.id.aboutfood);
        textViewf2 = itemView.findViewById(R.id.locationfood);
        textViewf3 = itemView.findViewById(R.id.namefood);
        textViewf4 = itemView.findViewById(R.id.phonefood);
        textViewf5 = itemView.findViewById(R.id.smsfood);
        textViewf6 = itemView.findViewById(R.id.whatsappfood);
        textViewf7 = itemView.findViewById(R.id.gpsfood);
        v = itemView;




    }
}
