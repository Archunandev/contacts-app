package com.example.splash.detailemergency;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.splash.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Detailepolice extends AppCompatActivity {


    private ImageView imageViewdetailpolice;
    TextView textviewdetailpolice1, textViewdetailpolice2, textViewdetailpolice3,textViewdetailpolice4,textViewdetailpolice5,textViewdetailpolice6;
    Button calluspolice, sendsmspolice, sendwhatsapppolice, mappolice,chatpolice;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailepolice);


        imageViewdetailpolice = findViewById(R.id.imageviewdetailpolice);
        textviewdetailpolice1 = findViewById(R.id.textviewdetailpolice1);
        textViewdetailpolice2 = findViewById(R.id.textviewdetailpolice2);
        textViewdetailpolice3 = findViewById(R.id.textviewdetailpolice3);
        textViewdetailpolice4 = findViewById(R.id.textviewdetailpolice4);
        textViewdetailpolice5 = findViewById(R.id.textviewdetailpolice5);
        textViewdetailpolice6 = findViewById(R.id.textviewdetailpolice6);
        calluspolice = findViewById(R.id.calluspolice);
        sendsmspolice = findViewById(R.id.sendsmspolice);
        sendwhatsapppolice = findViewById(R.id.sendwhatsapppolice);
        chatpolice = findViewById(R.id.startchatpolice);


        ref = FirebaseDatabase.getInstance().getReference().child("police");

        String policedetaile = getIntent().getStringExtra("policedetaile");

        ref.child(policedetaile).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String locationp = snapshot.child("locationp").getValue().toString();
                    String namep = snapshot.child("namep").getValue().toString();
                    String phonep =snapshot.child("phonep").getValue().toString();
                    String landlinep = snapshot.child("landlinep").getValue().toString();
                    String sendsmsp = snapshot.child("sendsmsp").getValue().toString();
                    String sendwhatsappp = snapshot.child("sendwhatsappp").getValue().toString();
                    String photop = snapshot.child("photop").getValue().toString();

                    Picasso.get().load(photop).into(imageViewdetailpolice);
                    textviewdetailpolice1.setText(locationp);
                    textViewdetailpolice2.setText(namep);
                    textViewdetailpolice3.setText(phonep);
                    textViewdetailpolice4.setText(landlinep);
                    textViewdetailpolice5.setText(sendsmsp);
                    textViewdetailpolice6.setText(sendwhatsappp);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        textViewdetailpolice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = " hello workers i want Mechanic here is my address...";
                String number = textViewdetailpolice5.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });

        sendsmspolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = " hello workers i want Mechanic here is my address...";
                String number = textViewdetailpolice5.getText().toString();

                Uri uri = Uri.parse("smsto:" + number);
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra("sms_body",message);
                startActivity(intent);

            }
        });
        textViewdetailpolice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetailpolice6.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });

        sendwhatsapppolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tonumber = textViewdetailpolice6.getText().toString();
                Uri uri = Uri.parse("smsto:" + tonumber);
                Intent i =new Intent(Intent.ACTION_SENDTO,uri);
                i.setPackage("com.whatsapp");
                startActivity(Intent.createChooser(i, ""));

            }
        });
        chatpolice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Detailepolice.this, "Currently not available", Toast.LENGTH_SHORT).show();
            }
        });









    }
}
