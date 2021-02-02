package com.example.splash.emergency;

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

import com.example.splash.Loading;
import com.example.splash.R;
import com.example.splash.detailemergency.Detailepolice;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

public class PoliceActivity extends AppCompatActivity {

    EditText inputsearchp;
    RecyclerView policerecycle;
    FirebaseRecyclerOptions<Policeuser> options;
    FirebaseRecyclerAdapter<Policeuser, Policeholders> adapter;
    DatabaseReference Databaserefp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police);

        final Loading loading = new Loading(PoliceActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },5000);


        Databaserefp = FirebaseDatabase.getInstance().getReference().child("police");

        inputsearchp = findViewById(R.id.inputsearchp);
        policerecycle = findViewById(R.id.policerecycle);
        policerecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        policerecycle.setHasFixedSize(true);

        LoadData("");
        inputsearchp.addTextChangedListener(new TextWatcher() {
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

        Query query = Databaserefp.orderByChild("locationp").startAt(data).endAt(data+"\uf8ff");

        options = new FirebaseRecyclerOptions.Builder<Policeuser>().setQuery(query,Policeuser.class).build();
        adapter = new FirebaseRecyclerAdapter<Policeuser, Policeholders>(options) {
            @NonNull
            @Override
            public Policeholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.policedata,parent,false);
                return new Policeholders(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull Policeholders holder, final int position, @NonNull Policeuser model) {

                holder.textViewp1.setText(model.getLocationp());
                holder.textViewp2.setText(model.getNamep());
                holder.textViewp3.setText(model.getPhonep());
                holder.textViewp4.setText(model.getLandlinep());
                holder.textViewp5.setText(model.getSendsmsp());
                holder.textViewp6.setText(model.getSendwhatsappp());
                Picasso.get().load(model.getPhotop()).into(holder.imageViewp);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(PoliceActivity.this, Detailepolice.class);
                        intent.putExtra("policedetaile",getRef(position).getKey());
                        startActivity(intent);
                    }
                });

            }
        };

        adapter.startListening();
        policerecycle.setAdapter(adapter);



    }
}
