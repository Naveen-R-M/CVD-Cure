package com.expert.cvd.Impact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.expert.cvd.R;

public class WorldOActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_o);
        WorldOActivity.Load load = new WorldOActivity.Load();
        load.execute();


    }
    public class Load extends AsyncTask {
        @Override
        protected Object doInBackground(Object[] objects) {
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            webView = findViewById(R.id.web);
            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.loadUrl("https://www.worldometers.info/coronavirus/");
        }
    }

}
