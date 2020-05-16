package com.expert.cvd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    Toolbar toolbar;
    CardView cv1,cv2,cv3;
    FirebaseDatabase database;
    DatabaseReference reference;
    TextView t_view1,t_view2,t_view3,t_view4;
    String total_cases,total_recovered,active_cases,total_deaths;
    private LocationManager manager;
    private LocationListener listener;
    private Double latitude, longitude;
    private String loc, city, state;
    Connection cn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);

        cv1 = findViewById(R.id.cv1);
        cv2 = findViewById(R.id.cv2);
        cv3 = findViewById(R.id.cv3);

        cn = new Connection(this);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, com.expert.cvd.Impact.ImpactActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, new Pair[]{Pair.create(cv1, "cv1_transition")});
                startActivity(intent,options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(HomeActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, com.expert.cvd.Preventive.PreventiveActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, new Pair[]{Pair.create(cv2, "cv2_transition")});
                startActivity(intent, options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(HomeActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, com.expert.cvd.Test.HealthActivity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, new Pair[]{Pair.create(cv3, "cv3_transition")});
                intent.putExtra("city",city);
                startActivity(intent,options.toBundle());
                if(!cn.isConnected()){
                    Toast.makeText(HomeActivity.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
            }
        });

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("stats");

        t_view1 = findViewById(R.id.t_view1);
        t_view2 = findViewById(R.id.t_view2);
        t_view3 = findViewById(R.id.t_view3);
        t_view4 = findViewById(R.id.t_view4);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                total_cases = dataSnapshot.child("total cases").getValue().toString();
                total_deaths = dataSnapshot.child("total deaths").getValue().toString();
                total_recovered = dataSnapshot.child("total recovered").getValue().toString();
                active_cases = dataSnapshot.child("active cases").getValue().toString();
                t_view1.setText(total_cases);
                t_view2.setText(total_deaths);
                t_view3.setText(total_recovered);
                t_view4.setText(active_cases);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                loc = Double.toString(location.getLatitude()) + Double.toString(location.getLongitude());
                loc(location);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {
                requestPermissions(new String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE
                }, 10);
                return;
            } else {
                configure();
            }
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    configure();
                }
                return;
        }
    }

    private void configure() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        manager.requestLocationUpdates("gps", 5000, 0, listener);
    }
    private void loc(Location location){
        Context context;
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude,longitude,1);
            city = addresses.get(0).getLocality();
            state = addresses.get(0).getAdminArea();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    Intent intent;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                intent = new Intent(HomeActivity.this,DevelopersActivity.class);
                startActivity(intent);
                break;


        }
        return super.onOptionsItemSelected(item);
    }

}
