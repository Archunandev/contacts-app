package com.example.splash.workers;

import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.splash.detailsworkers.Detailmechanic;
import com.example.splash.Loading;
import com.example.splash.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;


public class MechanicActivity extends AppCompatActivity {



    EditText inputsearchm;
    RecyclerView mechanicrecycle;
    FirebaseRecyclerOptions<Mechanicuser> options;
    FirebaseRecyclerAdapter<Mechanicuser, Mechanicholder>adapter;
    DatabaseReference Databaseref;

    TextView noresult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);

        final Loading loading = new Loading(MechanicActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },3000);


        Databaseref = FirebaseDatabase.getInstance().getReference().child("car");

        inputsearchm = findViewById(R.id.inputsearchm);
        mechanicrecycle = findViewById(R.id.mechanicrecycle);
        mechanicrecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mechanicrecycle.setHasFixedSize(true);

        LoadData("");

        inputsearchm.addTextChangedListener(new TextWatcher() {
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

        Query query = Databaseref.orderByChild("locationm").startAt(data).endAt(data+"\uf8ff");


        options = new FirebaseRecyclerOptions.Builder<Mechanicuser>().setQuery(query,Mechanicuser.class).build();

        adapter = new FirebaseRecyclerAdapter<Mechanicuser, Mechanicholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Mechanicholder holder, final int position, @NonNull Mechanicuser model) {

                holder.textViewm1.setText(model.getLocationm());
                holder.textViewm2.setText(model.getNamem());
                holder.textViewm3.setText(model.getPhonem());
                holder.textViewm4.setText(model.getSendsmsm());
                holder.textViewm5.setText(model.getSendwhatsappm());
                Picasso.get().load(model.getPhotom()).into(holder.imageViewm);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MechanicActivity.this, Detailmechanic.class);
                        intent.putExtra("CarKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });


            }

            @NonNull
            @Override
            public Mechanicholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mechanicdata,parent,false);
                return new Mechanicholder(v);
            }
        };

        adapter.startListening();
        mechanicrecycle.setAdapter(adapter);


    }

}
