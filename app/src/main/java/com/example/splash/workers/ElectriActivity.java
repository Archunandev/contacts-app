package com.example.splash.workers;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.splash.detailsworkers.Detailelectric;
import com.example.splash.Loading;
import com.example.splash.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class ElectriActivity extends AppCompatActivity {


    EditText inputsearche;
    RecyclerView electrirecycle;
    FirebaseRecyclerOptions<Electriuser> optionse;
    FirebaseRecyclerAdapter<Electriuser, Electriholder> adaptere;
    DatabaseReference dataref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electri);

        final Loading loading = new Loading(ElectriActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },5000);


        dataref = FirebaseDatabase.getInstance().getReference().child("electri");

        inputsearche = findViewById(R.id.inputsearche);
        electrirecycle = findViewById(R.id.electrirecycle);

        electrirecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        electrirecycle.setHasFixedSize(true);

        LoadData("");
        inputsearche.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString()!=null){
                    LoadData(s.toString());
                }else {
                    LoadData("");
                }

            }
        });


    }

    private void LoadData(String data) {

        Query query = dataref.orderByChild("locatione").startAt(data).endAt(data+"\uf8ff");

        optionse = new FirebaseRecyclerOptions.Builder<Electriuser>().setQuery(query,Electriuser.class).build();
        adaptere = new FirebaseRecyclerAdapter<Electriuser, Electriholder>(optionse) {
            @Override
            protected void onBindViewHolder(@NonNull Electriholder holder, final int position, @NonNull Electriuser model) {

                holder.textViewe1.setText(model.getLocatione());
                holder.textViewe2.setText(model.getNamee());
                holder.textViewe3.setText(model.getPhonee());
                holder.textViewe4.setText(model.getSendsmse());
                holder.textViewe5.setText(model.getSendwhatsappe());
                Picasso.get().load(model.getPhotoe()).into(holder.imageViewe);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ElectriActivity.this, Detailelectric.class);
                        intent.putExtra("ElectriKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });
            }

            @NonNull
            @Override
            public Electriholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.electridata,parent,false);

                return new Electriholder(v);
            }
        };
        adaptere.startListening();
        electrirecycle.setAdapter(adaptere);
    }
}