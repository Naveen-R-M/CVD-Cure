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

public class SpreadActivity extends AppCompatActivity {

    TextView t2;
    FirebaseDatabase database;
    DatabaseReference reference;
    String value1;
    Toolbar toolbar;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spread);
        t2 = findViewById(R.id.t2);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoView = findViewById(R.id.vv1);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);

        Uri uri = Uri.parse("https://firebasestorage.googleapis.com/v0/b/covid19-2-0.appspot.com/o/spread%2FHow%20does%20the%20coronavirus%20spread.mp4?alt=media&token=441e044f-c78d-4778-b560-d18c605c8912");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.start();

        database = FirebaseDatabase.getInstance();
        reference = database.getReference().child("spread");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                value1 = dataSnapshot.child("1").getValue().toString();

                t2.setText(value1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
