package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    String url;
    EditText text;
    WebView web;
    Button searchBtn, refreshBtn, backBtn, forwardBtn;
    ArrayList<String> urlHistory;
    Iterator<String> urlIter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by ID's.
        Button searchBtn = findViewById(R.id.search);
        ImageButton refreshBtn = findViewById(R.id.refresh);
        ImageButton backBtn = findViewById(R.id.back);
        ImageButton forwardBtn = findViewById(R.id.forward);
        EditText text = findViewById(R.id.editText);

        // Web view ID + set new Client to avoid opening in default browser but in app instead.
        WebView web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);

        ArrayList<String> urlHistory = new ArrayList<>();
        Iterator iter = urlHistory.iterator();

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://" + text.getText().toString();
                web.loadUrl(url);
                urlHistory.add(url);
                }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                web.loadUrl(web.getUrl());
            }
        });
    }
}