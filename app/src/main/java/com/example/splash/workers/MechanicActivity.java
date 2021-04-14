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
    FirebaseRecyclerOptions<Workersuser> options;
    FirebaseRecyclerAdapter<Workersuser, Workerholder>adapter;
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


        Databaseref = FirebaseDatabase.getInstance().getReference().child("Workermechanic");

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

        Query query = Databaseref.orderByChild("location").startAt(data).endAt(data+"\uf8ff");


        options = new FirebaseRecyclerOptions.Builder<Workersuser>().setQuery(query,Workersuser.class).build();

        adapter = new FirebaseRecyclerAdapter<Workersuser, Workerholder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull Workerholder holder, final int position, @NonNull Workersuser model) {

                holder.location.setText(model.getLocation());
                holder.name.setText(model.getName());
                holder.phone.setText(model.getPhone());
                holder.sendsms.setText(model.getSendsms());
                holder.sendwhatsapp.setText(model.getSendwhatsapp());
                holder.map.setText(model.getMap());
                holder.rank.setText(model.getRank());
                holder.since.setText(model.getSince());
                holder.age.setText(model.getAge());
                holder.exp.setText(model.getExp());
                holder.received.setText(model.getReceived());
                Picasso.get().load(model.getPhoto()).into(holder.workersphoto);
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
            public Workerholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.workerdata,parent,false);
                return new Workerholder(v);
            }
        };

        adapter.startListening();
        mechanicrecycle.setAdapter(adapter);


    }

}
