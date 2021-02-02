package com.example.splash.detailshops;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.splash.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class Detailfood extends AppCompatActivity {

    private static final  int REQUEST_CALL = 1;

    private ImageView imageViewdetailsf;
    TextView textviewdetailsf1, textViewdetailsf2, textViewdetailsf3,textViewdetailsf4,textViewdetailsf5,textViewdetailsf6,textViewdetailsf7;
    Button callfood, callsmsfood, callwhatsappfood, mapfood,chatfood;

    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailfood);

        imageViewdetailsf = findViewById(R.id.imageviewdetailf);
        textviewdetailsf1 = findViewById(R.id.textviewdetailfood1);
        textViewdetailsf2 = findViewById(R.id.textviewdetailfood2);
        textViewdetailsf3 = findViewById(R.id.textviewdetailfood3);
        textViewdetailsf4 = findViewById(R.id.textviewdetailfood4);

        textViewdetailsf5 = findViewById(R.id.textviewdetailfood5);
        textViewdetailsf6 = findViewById(R.id.textviewdetailfood6);
        textViewdetailsf7 = findViewById(R.id.textviewdetailfood7);

        textViewdetailsf6.setMovementMethod(LinkMovementMethod.getInstance());
        textViewdetailsf7.setMovementMethod(LinkMovementMethod.getInstance());


        ref = FirebaseDatabase.getInstance().getReference().child("hotel");

        String HotelKey = getIntent().getStringExtra("HotelKey");

        ref.child(HotelKey).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String aboutf = snapshot.child("aboutf").getValue().toString();
                    String locationf = snapshot.child("locationf").getValue().toString();
                    String namef = snapshot.child("namef").getValue().toString();
                    String phonef = snapshot.child("phonef").getValue().toString();
                    String sendsmsf = snapshot.child("sendsmsf").getValue().toString();
                    String sendwhatsappf = snapshot.child("sendwhatsappf").getValue().toString();
                    String photof = snapshot.child("photof").getValue().toString();
                    String gpsf = snapshot.child("gpsf").getValue().toString();

                    Picasso.get().load(photof).into(imageViewdetailsf);
                    textviewdetailsf1.setText(aboutf);
                    textViewdetailsf2.setText(locationf);
                    textViewdetailsf3.setText(namef);
                    textViewdetailsf4.setText(phonef);
                    textViewdetailsf5.setText(sendsmsf);
                    textViewdetailsf6.setText(sendwhatsappf);
                    textViewdetailsf7.setText(gpsf);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}