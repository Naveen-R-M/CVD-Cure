package com.expert.cvd.Preventive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import com.expert.cvd.R;

public class PreventiveActivity extends AppCompatActivity {

    Toolbar toolbar;
    CardView cv1,cv2,cv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventive);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreventiveActivity.this,PrecautionActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PreventiveActivity.this, new Pair[]{Pair.create(cv1, "cv1_transition")});
                startActivity(intent,options.toBundle());
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreventiveActivity.this,MythActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PreventiveActivity.this, new Pair[]{Pair.create(cv2, "cv4_transition")});
                startActivity(intent,options.toBundle());
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreventiveActivity.this,SpreadActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(PreventiveActivity.this, new Pair[]{Pair.create(cv3, "cv3_transition")});
                startActivity(intent,options.toBundle());
            }
        });

    }
}
