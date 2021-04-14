package com.example.splash.workers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.splash.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class Workerholder extends RecyclerView.ViewHolder {

    CircleImageView workersphoto;
    TextView location, name,phone,sendsms,sendwhatsapp,map,rank,since,age,exp,received;
    View v;

    public Workerholder(@NonNull View itemView) {
        super(itemView);

        workersphoto = itemView.findViewById(R.id.workersphoto);
        location = itemView.findViewById(R.id.location);
        name = itemView.findViewById(R.id.name);
        phone = itemView.findViewById(R.id.phone);
        sendsms = itemView.findViewById(R.id.sendsms);
        sendwhatsapp = itemView.findViewById(R.id.sendwhatsapp);
        map = itemView.findViewById(R.id.map);
        rank = itemView.findViewById(R.id.rank);
        since = itemView.findViewById(R.id.since);
        age = itemView.findViewById(R.id.age);
        exp = itemView.findViewById(R.id.exp);
        received = itemView.findViewById(R.id.received);
        v = itemView;
    }
}
