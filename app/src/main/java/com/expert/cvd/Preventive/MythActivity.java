package com.expert.cvd.Preventive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.expert.cvd.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MythActivity extends AppCompatActivity {

    TextView t2,t3,t5,t4,t6,t7;
    FirebaseDatabase database;
    DatabaseReference reference;
    String value1,value2,value3,value4,value5;
    Toolbar toolbar;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myth);

        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);
        t6 = findViewById(R.id.t6);
        t7 = findViewById(R.id.t7);

        videoView = findViewById(R.id.vv1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19-2-0.appspot.com/o/myths%2FCoronavirus%20Myths%20vs%20Facts.mp4?alt=media&token=e41b3393-2fae-4167-8745-8ef460ae24e9");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("myths");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.child("1").getValue().toString();
                value2 = dataSnapshot.child("2").getValue().toString();
                value3 = dataSnapshot.child("3").getValue().toString();
                value4 = dataSnapshot.child("4").getValue().toString();
                value5 = dataSnapshot.child("5").getValue().toString();

                t2.setText(value1);
                t4.setText(value2);
                t5.setText(value3);
                t6.setText(value4);
                t7.setText(value5);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
