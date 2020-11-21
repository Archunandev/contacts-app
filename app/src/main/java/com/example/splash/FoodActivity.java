package com.example.splash;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodActivity extends AppCompatActivity {

    EditText inputsearchf;
    RecyclerView foodrecycle;
    FirebaseRecyclerOptions<Fooduser> options;
    FirebaseRecyclerAdapter<Fooduser,Foodholders> adapter;
    DatabaseReference Databaseref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        final Loading loading = new Loading(FoodActivity.this);

        loading.StartLoadingDialog();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                loading.dismissDialog();

            }
        },2000);


        Databaseref = FirebaseDatabase.getInstance().getReference().child("hotel");

        inputsearchf = findViewById(R.id.inputsearchf);
        foodrecycle = findViewById(R.id.foodrecycle);
        foodrecycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        foodrecycle.setHasFixedSize(true);

        LoadData("");

        inputsearchf.addTextChangedListener(new TextWatcher() {
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

        Query query = Databaseref.orderByChild("locationf").startAt(data).endAt(data+"\uf8ff");

        options = new FirebaseRecyclerOptions.Builder<Fooduser>().setQuery(query,Fooduser.class).build();

        adapter = new FirebaseRecyclerAdapter<Fooduser, Foodholders>(options) {

            @NonNull
            @Override
            public Foodholders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_pager,parent,false);
                return new Foodholders(v);
            }

            @Override
            protected void onBindViewHolder(@NonNull Foodholders holder, final int position, @NonNull Fooduser model) {


                holder.textViewf1.setText(model.getAboutf());
                holder.textViewf2.setText(model.getLocationf());
                holder.textViewf3.setText(model.getNamef());
                holder.textViewf4.setText(model.getPhonef());
                holder.textViewf5.setText(model.getSendsmsf());
                holder.textViewf6.setText(model.getSendwhatsappf());
                holder.textViewf7.setText(model.getGpsf());
                Picasso.get().load(model.getPhotof()).into(holder.imageViewf);
                holder.v.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(FoodActivity.this,Detailfood.class);
                        intent.putExtra("HotelKey",getRef(position).getKey());
                        startActivity(intent);
                    }
                });


            }
        };
        adapter.startListening();
        foodrecycle.setAdapter(adapter);


    }
}