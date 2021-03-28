package com.example.viikko10;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
    int currentPosition = 0;
    String url;
    EditText text;
    WebView web;
    Button searchBtn, refreshBtn, backBtn, forwardBtn;
    ArrayList<String> urlHistory = new ArrayList<>();
    ListIterator iter = urlHistory.listIterator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find UI elements by ID's.
        Button searchBtn = findViewById(R.id.search);
        Button button2 = findViewById(R.id.button2);
        ImageButton refreshBtn = findViewById(R.id.refresh);
        ImageButton backBtn = findViewById(R.id.back);
        ImageButton forwardBtn = findViewById(R.id.forward);
        EditText text = findViewById(R.id.editText);

        // Web view ID + set new Client to avoid opening in default browser but in app instead.
        WebView web = findViewById(R.id.webView);
        web.setWebViewClient(new WebViewClient(

        ));
        web.getSettings().setJavaScriptEnabled(true);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Add http:// to URL string so user does not have to add it manually.
                String url = "http://" + text.getText().toString();
                web.loadUrl(url);
                // Make JS button disappear in default search.
                button2.setVisibility(View.INVISIBLE);
            }
        });

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Refresh = get current url and load it again.
                web.loadUrl(web.getUrl());
            }
        });


        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String url = text.getText().toString();
                // If user types "index.html", browser automatically redirects user to the site
                if (url.equals("index.html")) {
                    web.loadUrl("file:///android_asset/index.html");
                    iter.add(url);
                    // Set visibility of JS button "visible".
                    button2.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                // Execute JS shoutOut()- function
                web.evaluateJavascript("javascript: shoutOut()", null);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (web.canGoBack()){
                    web.goBack();
                }
            }
        });

        forwardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (web.canGoForward()){
                    web.goForward();
                }
            }
        });

    }
    }


