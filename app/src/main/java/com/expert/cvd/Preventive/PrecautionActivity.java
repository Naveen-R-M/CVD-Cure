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
import com.google.firebase.storage.FirebaseStorage;

public class PrecautionActivity extends AppCompatActivity {

    TextView t2,t3,t5,t4;
    FirebaseDatabase database;
    DatabaseReference reference;
    FirebaseStorage storage;
    String value1,value2,value3;
    Toolbar toolbar;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precaution);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);
        t5 = findViewById(R.id.t5);

        storage = FirebaseStorage.getInstance();

        videoView = findViewById(R.id.vv1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19-2-0.appspot.com/o/Precautions%2FWhat%20is%20CORONAVIRUS%20AND%20How%20to%20PROTECT%20YOURSELF.mp4?alt=media&token=5c2d2a4f-d1e6-4f68-9668-a40c7e3fcde0");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("precaution");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.child("1").getValue().toString();
                value2 = dataSnapshot.child("2").getValue().toString();
                value3 = dataSnapshot.child("3").getValue().toString();

                t2.setText(value1);
                t4.setText(value2);
                t5.setText(value3);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
