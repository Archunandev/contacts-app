package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlumberActivity extends AppCompatActivity {

    EditText inputsearchpl;
    RecyclerView plumberrecycle;
    FirebaseRecyclerOptions<Mechanicuser> options;
    FirebaseRecyclerAdapter<Mechanicuser,Mechanicholder> adapter;
    DatabaseReference Databaserefp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plumber);

        final Loading loading = new Loading(PlumberActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },5000);



        Databaserefp = FirebaseDatabase.getInstance().getReference().child("plumber");

        inputsearchpl = findViewById(R.id.inputsearchpl);
        plumberrecycle = findViewById(R.id.plumbercrecycle);
        plumberrecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        plumberrecycle.setHasFixedSize(true);

        LoadData("");

        inputsearchpl.addTextChangedListener(new TextWatcher() {
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

        Query query = Databaserefp.orderByChild("locationm").startAt(data).endAt(data+"\uf8ff");

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
                        Intent intent = new Intent(PlumberActivity.this,Detailplumber.class);
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
        plumberrecycle.setAdapter(adapter);



    }
}
