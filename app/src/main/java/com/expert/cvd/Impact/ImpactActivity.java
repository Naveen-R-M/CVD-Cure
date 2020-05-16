package com.expert.cvd.Impact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.expert.cvd.Connection;
import com.expert.cvd.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ImpactActivity extends AppCompatActivity {

    LineChart line1,line2;
    Toolbar tb1;
    FirebaseDatabase database;
    DatabaseReference reference,reference1,reference2;
    String x1,x2,x3,x4,x5,x6,x7;
    String y1,y2,y3,y4,y5,y6,y7;
    CardView cv1,cv2,cv3;
    Connection cn;
    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_impact);

        line1 = findViewById(R.id.line1);
        line2 = findViewById(R.id.line2);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);

        cn = new Connection(this);

        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImpactActivity.this, BingActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ImpactActivity.this, new Pair[]{Pair.create(cv1, "cv1_transition")});
                startActivity(intent,options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(ImpactActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImpactActivity.this, BBCActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ImpactActivity.this, new Pair[]{Pair.create(cv2, "cv2_transition")});
                startActivity(intent,options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(ImpactActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImpactActivity.this, WorldOActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(ImpactActivity.this, new Pair[]{Pair.create(cv2, "cv2_transition")});
                startActivity(intent,options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(ImpactActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });


        tb1 = findViewById(R.id.toolbar);
        setSupportActionBar(tb1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("graphs");
        reference1 = database.getReference("graphs");
        reference2 = database.getReference("months");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                x1 = dataSnapshot.child("bar").child("x1").getValue().toString();
                x2 = dataSnapshot.child("bar").child("x2").getValue().toString();
                x3 = dataSnapshot.child("bar").child("x3").getValue().toString();
                x4 = dataSnapshot.child("bar").child("x4").getValue().toString();
                x5 = dataSnapshot.child("bar").child("x5").getValue().toString();
                x6 = dataSnapshot.child("bar").child("x6").getValue().toString();
                x7 = dataSnapshot.child("bar").child("x7").getValue().toString();

                y1 = dataSnapshot.child("bar").child("y1").getValue().toString();
                y2 = dataSnapshot.child("bar").child("y2").getValue().toString();
                y3 = dataSnapshot.child("bar").child("y3").getValue().toString();
                y4 = dataSnapshot.child("bar").child("y4").getValue().toString();
                y5 = dataSnapshot.child("bar").child("y5").getValue().toString();
                y6 = dataSnapshot.child("bar").child("y6").getValue().toString();
                y7 = dataSnapshot.child("bar").child("y7").getValue().toString();

                ArrayList<Entry> list = new ArrayList<Entry>();
                list.add(new Entry(Integer.parseInt(y1),Integer.parseInt(x1)));
                list.add(new Entry(Integer.parseInt(y2),Integer.parseInt(x2)));
                list.add(new Entry(Integer.parseInt(y3),Integer.parseInt(x3)));
                list.add(new Entry(Integer.parseInt(y4),Integer.parseInt(x4)));
                list.add(new Entry(Integer.parseInt(y5),Integer.parseInt(x5)));
                list.add(new Entry(Integer.parseInt(y6),Integer.parseInt(x6)));
                list.add(new Entry(Integer.parseInt(y7),Integer.parseInt(x7)));

                LineDataSet dataSet = new LineDataSet(list, "Impact");

                LineData data = new LineData(dataSet);
                line1.setData(data);
                line1.setVisibility(View.VISIBLE);
                line1.setTouchEnabled(true);
                line1.setDragEnabled(true);
                line1.setScaleEnabled(true);
                Description description = new Description();
                description.setText("Active cases on each day");
                line1.setDescription(description);
                line1.animateY(3000);
                line1.setPinchZoom(true);
                line1.setDoubleTapToZoomEnabled(true);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                try {

                    y1 = dataSnapshot.child("line").child("y1").getValue().toString();
                    y2 = dataSnapshot.child("line").child("y2").getValue().toString();
                    y3 = dataSnapshot.child("line").child("y3").getValue().toString();
                    y4 = dataSnapshot.child("line").child("y4").getValue().toString();
                    y5 = dataSnapshot.child("line").child("y5").getValue().toString();
                    y6 = dataSnapshot.child("line").child("y6").getValue().toString();
                    y7 = dataSnapshot.child("line").child("y7").getValue().toString();

                    x1 = dataSnapshot.child("line").child("x1").getValue().toString();
                    x2 = dataSnapshot.child("line").child("x2").getValue().toString();
                    x3 = dataSnapshot.child("line").child("x3").getValue().toString();
                    x4 = dataSnapshot.child("line").child("x4").getValue().toString();
                    x5 = dataSnapshot.child("line").child("x5").getValue().toString();
                    x6 = dataSnapshot.child("line").child("x6").getValue().toString();
                    x7 = dataSnapshot.child("line").child("x7").getValue().toString();

                    ArrayList<Entry> list = new ArrayList<Entry>();
                    list.add(new Entry(Integer.parseInt(y1),Integer.parseInt(x1)));
                    list.add(new Entry(Integer.parseInt(y2),Integer.parseInt(x2)));
                    list.add(new Entry(Integer.parseInt(y3),Integer.parseInt(x3)));
                    list.add(new Entry(Integer.parseInt(y4),Integer.parseInt(x4)));
                    list.add(new Entry(Integer.parseInt(y5),Integer.parseInt(x5)));
                    list.add(new Entry(Integer.parseInt(y6),Integer.parseInt(x6)));
                    list.add(new Entry(Integer.parseInt(y7),Integer.parseInt(x7)));

                    LineDataSet dataSet = new LineDataSet(list, "Future Predictions");

                    LineData data = new LineData(dataSet);
                    line2.setData(data);
                    line2.setVisibility(View.VISIBLE);
                    line2.setTouchEnabled(true);
                    line2.setDragEnabled(true);
                    line2.setScaleEnabled(true);
                    Description description = new Description();
                    description.setText("\nFuture predictions as per the present day's status of active cases");
                    line2.setDescription(description);
                    line2.animateY(3000);
                    line2.setPinchZoom(true);
                    line2.setDoubleTapToZoomEnabled(true);
                }
                catch (Exception e){
                    Toast.makeText(ImpactActivity.this, "Check your Internet connection.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tv1.setText(dataSnapshot.child("1").getValue().toString());
                tv2.setText(dataSnapshot.child("2").getValue().toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
