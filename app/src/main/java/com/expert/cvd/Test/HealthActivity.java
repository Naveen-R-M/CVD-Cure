package com.expert.cvd.Test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.expert.cvd.R;

public class HealthActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Toolbar toolbar;
    RadioGroup rg1,rg2,rg3,rg4,rg5,rg6,rg7,rg8,rg9,rg10;
    RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9,rb10;
    EditText et1,et2;
    ImageButton img_btn1;
    String state,city,a,b,c,d,e,f,g,h,i,j,name,add;
    Button b1;
    int flag;
    Spinner spinner;
    String states;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        toolbar = findViewById(R.id.toolbar);
        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.state,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        b1 = findViewById(R.id.b1);

        state = getIntent().getStringExtra("state");
        city = getIntent().getStringExtra("City");

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);

        img_btn1 = findViewById(R.id.img_btn1);

        img_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(states.contentEquals("Andhra Pradesh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:+91 08662410978"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Arunachal Pradesh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9536055743"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Assam")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:6913347770"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Bihar")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Chhattisgarh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:077122-35091"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Goa")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Gujarat")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Haryana")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:8558893911"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Himachal Pradesh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Jharkhand")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Karnataka")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Kerala")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0471-2552056"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Madhya Pradesh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0755-2527177"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Maharashtra")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:020-26127394"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Manipur")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:3852411668"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Meghalaya")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9366090748"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Mizoram")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:102"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Nagaland")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:7005539653"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Odisha")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9439994859"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Punjab")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Rajasthan")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0141-2225624"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Sikkim")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Tamil Nadu")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:044-29510500"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Telangana")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Tripura")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:0381-2315879"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Uttar Pradesh")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:104"));
                    startActivity(intent);
                }
                else if(states.contentEquals("Uttarakhand")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:18001805145"));
                    startActivity(intent);
                }
                else if(states.contentEquals("West Bengal")){
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:3323412600"));
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:1123978046"));
                    startActivity(intent);
                }


            }
        });

        rg1 = findViewById(R.id.rg1);
        rg2 = findViewById(R.id.rg2);
        rg3 = findViewById(R.id.rg3);
        rg4 = findViewById(R.id.rg4);
        rg5 = findViewById(R.id.rg5);
        rg6 = findViewById(R.id.rg6);
        rg7 = findViewById(R.id.rg7);
        rg8 = findViewById(R.id.rg8);
        rg9 = findViewById(R.id.rg9);
        rg10 = findViewById(R.id.rg10);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rb1 = findViewById(rg1.getCheckedRadioButtonId());
                rb2 = findViewById(rg2.getCheckedRadioButtonId());
                rb3 = findViewById(rg3.getCheckedRadioButtonId());
                rb4 = findViewById(rg4.getCheckedRadioButtonId());
                rb5 = findViewById(rg5.getCheckedRadioButtonId());
                rb6 = findViewById(rg6.getCheckedRadioButtonId());
                rb7 = findViewById(rg7.getCheckedRadioButtonId());
                rb8 = findViewById(rg8.getCheckedRadioButtonId());
                rb9 = findViewById(rg9.getCheckedRadioButtonId());
                rb10 = findViewById(rg10.getCheckedRadioButtonId());


                try {
                    a = rb1.getText().toString();
                    b = rb2.getText().toString();
                    c = rb3.getText().toString();
                    d = rb4.getText().toString();
                    e = rb5.getText().toString();
                    f = rb6.getText().toString();
                    g = rb7.getText().toString();
                    h = rb8.getText().toString();
                    i = rb9.getText().toString();
                    j = rb10.getText().toString();

                }catch(Exception e){

                }

                name = et1.getText().toString();
                add  = et2.getText().toString();

                if(!(TextUtils.isEmpty(a)||TextUtils.isEmpty(b)||TextUtils.isEmpty(c)||TextUtils.isEmpty(d))){
                    if(!(TextUtils.isEmpty(name)||TextUtils.isEmpty(add))){
                        if ((b.contentEquals("Corona Infected Countries")||(b.contentEquals("Across India")||(b.contentEquals("Nowhere")))) && (c.contentEquals("Yes")) && (d.contentEquals("Yes")||d.contentEquals("No")) && (e.contentEquals("Yes"))&&(f.contentEquals("Yes"))&& (g.contentEquals("Yes")|g.contentEquals("No"))&&(h.contentEquals("Yes")||h.contentEquals("No"))&&(i.contentEquals("Yes")||i.contentEquals("No")) &&(j.contentEquals("Diabetes")||j.contentEquals("HyperTension")||j.contentEquals("CardiacDisease")||j.contentEquals("Previously any Immuno Compressed"))){
                            Intent intent = new Intent(HealthActivity.this, com.expert.cvd.Test.ResultActivity.class);
                            String a = "Your possibilities of suffering from corona are way too high";
                            intent.putExtra("desc",a);
                            startActivity(intent);
                        }
                        else if ((b.contentEquals("Corona Infected Countries")||(b.contentEquals("Across India")||(b.contentEquals("Nowhere")))) && (c.contentEquals("No")) && (d.contentEquals("No")) && (e.contentEquals("No"))&&(f.contentEquals("No"))&& (g.contentEquals("No"))&&(h.contentEquals("No"))&&(i.contentEquals("No")) &&(j.contentEquals("None"))){
                            Intent intent = new Intent(HealthActivity.this, com.expert.cvd.Test.ResultActivity.class);
                            String a = "No need to afraid.\nYou are good to go..!";
                            intent.putExtra("desc",a);
                            startActivity(intent);
                        }
                        else if ((b.contentEquals("Corona Infected Countries")||b.contentEquals("Across India")||b.contentEquals("Nowhere")) && (c.contentEquals("Yes")) && (d.contentEquals("Yes") ||d.contentEquals("No")) && (e.contentEquals("Yes"))&&(f.contentEquals("No")||f.contentEquals("Yes"))&& ( g.contentEquals("Yes")||g.contentEquals("No"))&&(h.contentEquals("Yes")||h.contentEquals("No"))&&(i.contentEquals("Yes")||i.contentEquals("No")) &&(j.contentEquals("Diabetes")||j.contentEquals("HyperTension")||j.contentEquals("CardiacDisease")|| j.contentEquals("Previously any Immuno Compressed")|| j.contentEquals("None"))) {
                            Intent intent = new Intent(HealthActivity.this, com.expert.cvd.Test.ResultActivity.class);
                            String a = "Your symptoms partially matches with novel corona virus.\nConsult a medic asap.";
                            intent.putExtra("desc", a);
                            startActivity(intent);
                        }
                        else if((b.contentEquals("Corona Infected Countries")|| b.contentEquals("Across India")|| b.contentEquals("Nowhere")) && (c.contentEquals("Yes")|| c.contentEquals("No")) &&(d.contentEquals("No")||d.contentEquals("Yes"))&&(e.contentEquals("Yes"))&&(f.contentEquals("Yes")||f.contentEquals("No"))&&(g.contentEquals("No")||g.contentEquals("Yes"))&&(h.contentEquals("Yes")||h.contentEquals("No"))&&(i.contentEquals("No")||i.contentEquals("Yes"))&&(j.contentEquals("Diabetes")||j.contentEquals("HyperTension")||j.contentEquals("CardiacDisease")||j.contentEquals("Previously any Immuno Compressed")||j.contentEquals("None")))
                            {
                            Intent intent = new Intent(HealthActivity.this, com.expert.cvd.Test.ResultActivity.class);
                            String a = "You may have a lower respiratory illness.\nThere's nothing to worry about.";
                            intent.putExtra("desc", a);
                            startActivity(intent);
                        }
                        else{
                            Intent intent = new Intent(HealthActivity.this, com.expert.cvd.Test.ResultActivity.class);
                            String a = "There is no serious issues";
                            intent.putExtra("desc", a);
                            startActivity(intent);
                        }
                    }else{
                        Toast.makeText(HealthActivity.this, "Please fill in all the details", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(HealthActivity.this, "Please check all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        states = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, states , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
